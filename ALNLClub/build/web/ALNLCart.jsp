<%-- 
    Document   : ALNLCart
    Created on : Mar 31, 2023, 1:24:04 a.m.
    Author     : Alfredo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ALNLBanner.jsp" />

<div>
    
    <h3 class="text-center">Your Loan Cart</h3>
    <div class="cartTable">
        <table class="table">
            <colgroup>
                    <col span="1" style="width: 50px;">
                    <col span="1" style="width: 300px;">
                    <col span="1" style="width: 50px;">
            </colgroup>
            <thead>
                <tr>
                    <th scope="col" style="text-align: left">Code</th>
                    <th scope="col" style="text-align: left">Description</th>
                    <th scope="col" style="text-align: left">Quantity</th>
                </tr>
            </thead>
            <tbody class="mb-5">
                
                <%-- declare var for the count of the total qty of items in cart  --%>
                <c:set var="count" scope="page" value="0"/>
                <c:forEach var="book" items="${sessionScope.myCart.items}">
                    <tr>
                        <td align="left">${book.code}</td>
                        <td align="left">${book.description}</td>
                        <td align="right">${book.quantity}</td>
                    </tr>
                    <%-- set qty of items to var  --%>
                    <c:set var="count" scope="page" value="${count + book.quantity}"/>
                </c:forEach>
                    
                <tr>
                    <td align="left"><br /></td>
                    <td align="left"><br /></td>
                    <td align="left"><br /></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td class="font-weight-bold" colspan="2" align="right">Total</td>
                    <td class="font-weight-bold" align="right"><c:out value = "${count}"/></td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div>
        <a href="ALNLClearCart">Clear the cart</a> <br>
        <a href="ALNLLoan">Return to eLoan</a>
    </div>
    
</div>

<jsp:include page="ALNLFooter.jsp" />