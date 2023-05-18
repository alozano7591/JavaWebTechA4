<%-- 
    Document   : ALNLEditMember
    Created on : Apr 14, 2023, 11:10:40 AM
    Author     : Nikita
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ALNLBanner.jsp" />
    
    <h2>Edit an Existing Member</h2>
    <h4 style="color: red; font-style: italic;">${message}</h4>
    
    <form action="ALNLMemberAdmin?email=${member.emailAddress}&action=saveMember&db_operation=update" method="post" class="memberForm">
        
        <div class="memberFormRow">
            <label for="email">Email:</label> 
            <input type="text" id="email" name="email" value="${member.emailAddress}" style="width: 350px;" disabled>
        </div>

        <div class="memberFormRow">
            <label for="name">Full Name:</label> 
            <input type="text" id="name" name="name" value="${member.fullName}" style="width: 230px">
        </div>
        
        <div class="memberFormRow">
            <label for="name">Phone::</label> 
            <input type="text" id="phone" name="phone" value="${member.phoneNumber}" style="width: 100px;">
        </div>
        
        <div class="memberFormRow">
            <label for="program">IT Program: </label> 
            <select id="program" name="program" style="width: 80px;">
                <option value="CAS" ${"CAS".equals(member.programName) ? "selected" : ""}>CAS</option>
                <option value="SQATE" ${"SQATE".equals(member.programName) ? "selected" : ""}>SQATE</option>
                <option value="CPA" ${"CPA".equals(member.programName) ? "selected" : ""}>CPA</option>
                <option value="CP" ${"CP".equals(member.programName) ? "selected" : ""}>CP</option>
                <option value="ITID" ${"ITID".equals(member.programName) ? "selected" : ""}>ITID</option>
                <option value="CAD" ${"CAD".equals(member.programName) ? "selected" : ""}>CAD</option>
                <option value="ITSS" ${"ITSS".equals(member.programName) ? "selected" : ""}>ITSS</option>
            </select>
        </div>
        
        <div class="memberFormRow">
            <label for="year">Year Level:  </label>
            <select id="year" name="year" style="width: 35px;">
                <option value="1" ${"1".equals(String.valueOf(member.yearLevel)) ? "selected" : ""}>1</option>
                <option value="2" ${"2".equals(String.valueOf(member.yearLevel)) ? "selected" : ""}>2</option>
                <option value="3" ${"3".equals(String.valueOf(member.yearLevel)) ? "selected" : ""}>3</option>
                <option value="4" ${"4".equals(String.valueOf(member.yearLevel)) ? "selected" : ""}>4</option>
            </select>
        </div>
        
        <input type="submit" value="Save">
        <button type="button" onclick="window.location='ALNLMemberAdmin?action=editMember&email=${member.emailAddress}'">Reset</button></p>
    </form>
    
 <jsp:include page="ALNLFooter.jsp" />
