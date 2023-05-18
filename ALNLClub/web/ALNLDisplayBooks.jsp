<%-- 
    Document   : ALNLDisplayBooks
    Created on : Mar 9, 2023, 11:51:51 p.m.
    Author     : Alfredo 
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="club.business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


            <jsp:include page="ALNLBanner.jsp" />
            
            <h1>List of Books</h1>
            
            <p>Table thing</p>
            <table class="booksTable">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Description</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
                        for (int i = 0; i < books.size(); i++) {
                        Book book = books.get(i);
                    %>
                    <tr>
                        <td><%= book.getCode() %></td>
                        <td><%= book.getDescription() %></td>
                        <td><%= book.getQuantity() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>    
            
            <form action="ALNLAddBook.jsp">
                <input type="submit" value="Add Book">
            </form>
            
            <jsp:include page="ALNLFooter.jsp" />
        