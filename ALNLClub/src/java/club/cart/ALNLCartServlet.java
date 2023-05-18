/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fredd
 */
@WebServlet(name = "ALNLCartServlet", urlPatterns = {"/ALNLCart"})
public class ALNLCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        // making context object and loands
        ServletContext context = this.getServletContext();
        ArrayList<Book> loanItems = (ArrayList<Book>) context.getAttribute("loanItems");
        
        HttpSession mySession = request.getSession();
        
        ECart myCart = (ECart) mySession.getAttribute("myCart");
        
        if (myCart == null) {
            myCart = new ECart();
        }

        String reserve = request.getParameter("action");

        String reserveCode = (String) request.getParameter("code");
        if (reserve != null && !reserveCode.isEmpty()) {
            Book tempBook = ELoan.findItem(loanItems, reserveCode);

            //adding item to my cart
            myCart.addItem(tempBook);

            // using subtract call to update the loan item count
            ELoan.subtractFromQOH(loanItems, reserveCode, 1);
            mySession.setAttribute("myCart", myCart);
        }

        // forwarding control to ALNLCart
        getServletContext().getRequestDispatcher("/ALNLCart.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
        
        //was going to put some stuff here
        int books = 0;
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
        processRequest(request, response);
        //nothing here because there's nothing in the post that does anything;
        
        //was going to put some stuff here
        int books = 10;
        int myCart = 10;
        int exrtaData = 10;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
        
    }// </editor-fold>

}
