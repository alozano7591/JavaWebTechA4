<%-- 
    Document   : ALNLRemoveMember
    Created on : Apr 14, 2023, 2:29:34 PM
    Author     : Nikita
--%>

<%@page import="club.business.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ALNLBanner.jsp" />
    <%Member member = (Member) request.getAttribute("member"); %>
    
    <h2>Do you want to delete this member?</h2>
    
    <form action="ALNLMemberAdmin?&action=deleteMember&email=<%=member.getEmailAddress()%>" method="post" class="memberForm">
        <div class="memberFormRow"><!-- for the member email -->
            <label for="email">Email:</label> 
            <input type="text" id="email" name="email" value="${member.getEmailAddress()}" style="width: 350px;" disabled>
        </div>
        
        <div class="memberFormRow"><!-- for the member name -->
            <label for="name">Full Name:</label> 
            <input type="text" id="name" name="name" value="${member.getFullName()}" style="width: 220px" disabled>
        </div>
        
        <div class="memberFormRow"><!-- for the member Phone: -->
            <label for="phone">Phone:</label> 
            <input type="text" id="phone" name="phone" value="${member.getPhoneNumber()}" style="width: 100px;" disabled>
        </div>
        
        
        <div class="memberFormRow"><!-- for the member program -->
            <label for="program">IT Program: </label> 
            <input type="text" id="program" name="program" value="${member.getProgramName()}" style="width: 50px;;" disabled>
        </div>
        
        <div class="memberFormRow"><!-- for the member year -->
            <label for="year">IT Program: </label> 
            <input type="text" id="year" name="year" value="${member.getYearLevel()}" style="width: 50px;" disabled>
        </div>
            
        <input type="submit" value="Yes">
        <button type="button" onclick="window.location='ALNLMemberAdmin?action=displayMembers'">No</button>
    </form>
    
 <jsp:include page="ALNLFooter.jsp" />