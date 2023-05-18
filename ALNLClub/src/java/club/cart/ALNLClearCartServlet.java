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
@WebServlet(name = "ALNLClearCartServlet", urlPatterns = {"/ALNLClearCart"})
public class ALNLClearCartServlet extends HttpServlet {

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
        
        HttpSession mySession = request.getSession();
        
        //getting my Cart ojbect ready
        ECart myCart;

        
        if (mySession.getAttribute("myCart") != null) {
            // assigning session attribute to myCart          
            // and the ngetting books and loanitems
            myCart = (ECart) mySession.getAttribute("myCart");
            ServletContext context = this.getServletContext();
            ArrayList<Book> loanItems = (ArrayList<Book>) context.getAttribute("loanItems");

            // Getting items and looping through to see which need uptating
            for(int i = 0; i < myCart.getItems().size(); i++)
            {
                ELoan.addToQOH(
                        loanItems, 
                        myCart.getItems().get(i).getCode(), 
                        myCart.getItems().get(i).getQuantity());
            }

            // Invalidating session obj
            myCart = new ECart();
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
        
        //extra data to add
        int books = 10;
        int apples = 10;
        int carts = 10;
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
