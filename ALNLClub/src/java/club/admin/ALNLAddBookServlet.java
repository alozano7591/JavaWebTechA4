/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikita and Alfredo
 */
@WebServlet(name = "ALNLAddBook", urlPatterns = {"/ALNLAddBook"})
public class ALNLAddBookServlet extends HttpServlet {

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
        String filePath = getServletContext().getRealPath("/WEB-INF/books.txt");
        
        //server-side error validation
        String errorMessage = "";
        String url = "";
        
        // get input parameters
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String quantityString = request.getParameter("quantity");
        
        // default value for qty string
        if (quantityString == null || quantityString.isEmpty()) {
            quantityString = "0";
        }
        
        //the number of books
        int quantityOfBook = Integer.parseInt(quantityString);
         
        // create and object for the book for storing
        Book book = new Book(code, description, quantityOfBook);
        request.setAttribute("book", book);
        
        if (code == null || code.isEmpty()) {
            errorMessage += "Book code is required. <br>";
        }
        if (description == null || description.isEmpty() || description.length() < 3) {
            errorMessage += "Description must have at least 3 characters. <br>";
        }
        if (quantityOfBook <= 0) {
            errorMessage += "Quantity must be a positive number. <br>";
        }
        if (errorMessage.isEmpty()) {
            // Call the insert function to store book to txt file
            BookIO.insert(book, filePath);
             // forward to the DisplayBook page
            url = "/ALNLDisplayBooks";
        } else {
        // if there are no errors than get attributes
        // and forward to the ALNLAddBook page
            request.setAttribute("errors", errorMessage);
            request.setAttribute("quantityString", quantityString);
            url = "/ALNLAddBook.jsp";
        }
        
        request.getRequestDispatcher(url).forward(request, response);
        
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
