/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package club.admin;

import club.business.Member;
import club.data.MemberDB;
import club.business.Book;
import club.business.ELoan;
import java.io.IOException;
import java.io.PrintWriter;
import static java.rmi.server.LogStream.log;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alfredo
 */
public class ALNLMemberAdminController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet processRequest method. Not used in this project">
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    */
    // </editor-fold>
    

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = this.getServletContext();

        //this is the default path in the event that the doGet is called
        String url = "/ALNLDisplayMembers.jsp";
        
        //If action parameter is not defined the default action is “displayMembers”, 
        //which will display the list of members (see display members screenshot below).
        String[] memberActions = request.getParameterValues("action");
        String action = "displayMembers";
        
        //initialize an action variable
        ArrayList<Member> members;          //initialize an array list for members
        
        //if member actions is not null and has one index, then assign action value to action string
        if(memberActions != null && memberActions.length > 0)
        {
            action = memberActions[0];
        }
        
        //check what the value of our action is and act accordingly
        switch (action) {
            case "displayMembers":
                members = MemberDB.selectMembers();
                context.setAttribute("members", members);
                break;
            case "addMember":
                url = "/ALNLAddMember.jsp";
                break;
            case "editMember":
                {
                    String email = request.getParameter("email");
                    Member member = MemberDB.selectMember(email);
                    context.setAttribute("member", member);
                    url = "/ALNLEditMember.jsp";
                    break;
                }
            case "removeMember":
                {
                    String email = request.getParameter("email");
                    Member member = MemberDB.selectMember(email);
                    request.setAttribute("member", member);
                    url = "/ALNLRemoveMember.jsp";
                    break;
                }
            default:
                members = (ArrayList<Member>) MemberDB.selectMembers();
                if (members != null) {
                context.setAttribute("members", members);
                }
                break;
        }
        
        request.getRequestDispatcher(url).forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = this.getServletContext();
        ArrayList<Member> members;
        
        String action = request.getParameter("action");
        if (action != null && action.equals("saveMember")) {
            
            String url = saveMember(request, response);
            members = MemberDB.selectMembers();
            context.setAttribute("members", members);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            
        }
        else if (action != null && action.equals("deleteMember")) {
            
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            MemberDB.delete(member);
            members = MemberDB.selectMembers();
            context.setAttribute("members", members);
            getServletContext().getRequestDispatcher("/ALNLDisplayMembers.jsp").forward(request, response);
            
        }
        
    }
    
    /**
     * Used for saving members to database. Used for adding new members or updating existing ones.
     * @param request
     * @param response
     * @return 
     */
    private String saveMember(HttpServletRequest request, HttpServletResponse response) {
        
        ServletContext context = this.getServletContext();
        String url = "/ALNLDisplayMembers.jsp";
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String program = request.getParameter("program");
        String year = request.getParameter("year");
        
        String dbOp = request.getParameter("db_operation");

        Member member = new Member(name, email);

        if (member.isValid()) {
            
            //update values using member obj
            member.setEmailAddress(email);
            member.setFullName(name);
            member.setPhoneNumber(phone);
            member.setProgramName(program);
            member.setYearLevel(Integer.parseInt(year));
            
            //check if our member already exists using their email, 
            //if so then update the member, otherwise...
            //make new member
            if(!MemberDB.emailExists(email)){
                MemberDB.insert(member);
            }
            else{
                MemberDB.update(member);
            }
            
            
        } 
        else {
            
            if (dbOp != null && dbOp.equals("update")) {
                
                //send back a message asking for a name to update
                String message = "Cannot update this record. Please provide a valid name";
                Member original = MemberDB.selectMember(email);
                request.setAttribute("member", original);
                url = "/ALNLEditMember.jsp";
                request.setAttribute("message", message);
                
            }
            else  {
                //send back an error message asking for name and email to create new member
                String message = "Cannot insert a new record. Please provide a valid name and/or email";
                url = "/ALNLAddMember.jsp";
                request.setAttribute("message", message);
                
            }
        }

        return url;
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void Log(String a_log) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
