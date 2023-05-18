<%-- 
    Document   : ALNLAddBook
    Created on : Mar 10, 2023, 4:39:04 PM
    Author     : Nikita 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ALNLBanner.jsp" />

            
    <h1>Add Book</h1>
    <% String errorMessage = (String) request.getAttribute("errors");
    if (errorMessage != null) { %>
    <div id="errorMessage">
        <%= errorMessage %>
    </div>
    <% } %>
        <form action="ALNLAddBook" method="POST">
            <div class="addBookTable">
                <table>
                    <tr>
                        <td>Code:</td>
                        <td><input type="text" name="code" id="code"></td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><input type="text" name="description" id="description" style="width: 500px;"></td>
                    </tr>
                    <tr>
                        <td>Quantity:</td>
                        <td><input type="text" name="quantity" id="quantity" value="${quantityString}" style="width: 50px;"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Save">
                            <input type="button" value="Cancel" onclick="window.location.href='ALNLDisplayBooks'">
                        </td>
                    </tr>
                </table>
            <div>
        </form>    
                    
<jsp:include page="ALNLFooter.jsp" />

