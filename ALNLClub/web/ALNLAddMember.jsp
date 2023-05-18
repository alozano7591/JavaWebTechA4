<%-- 
    Document   : ALNLAddMember
    Created on : Apr 13, 2023, 11:39:45 p.m.
    Author     : Alfredo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ALNLBanner.jsp" />
   
    <h2>Add a New Member</h2>
    
    <h4 style="color: red; font-style: italic;">${message}</h4>
    
         
    <form action="ALNLMemberAdmin?action=saveMember" method="post" class="memberForm">
        
        <div class="memberFormRow"><!-- for the member email -->
            <label for="email">Email:</label> 
            <input type="text" id="email" name="email" style="width: 350px;">
        </div>

        <div class="memberFormRow"><!-- full name -->
            <label for="name">Full Name:</label> 
            <input type="text" id="name" name="name" style="width: 230px;">
        </div>

        <div class="memberFormRow"><!-- add phone -->
            <label for="name">Phone:</label> 
            <input type="text" id="phone" name="phone" style="width: 100px;">
        </div>

        <div class="memberFormRow"><!-- programs -->
            <label for="program">Program: </label> 
            <select id="program" name="program" style="width: 80px;">
                <option value="CAS">CAS</option>
                <option value="SQATE">SQATE</option>
                <option value="CPA">CPA</option>
                <option value="CP">CP</option>
                <option value="ITID">ITID</option>
                <option value="CAD">CAD</option>
                <option value="ITSS">ITSS</option>
            </select>
        </div>
        
        <div class="memberFormRow">
            <label for="year">Year Level:  </label>
            <select id="year" name="year" style="width: 35px;">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
        </div>
        
        <input type="submit" value="Save">
        <button type="button" onclick="window.location='ALNLMemberAdmin?action=addMember'">Reset</button></p>
   </form>
   

    
 <jsp:include page="ALNLFooter.jsp" />