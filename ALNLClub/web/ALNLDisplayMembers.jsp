<%-- 
    Document   : ALNLDisplayMembers
    Created on : Apr 12, 2023, 6:56:03 p.m.
    Author     : Alfredo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ALNLBanner.jsp" />

<div>
    
    <h1>List Of Members</h1>
    
<div class="loansTable">
            
        <table >
            <colgroup>
                <col span="1" style="width: 150px;">
                <col span="1" style="width: 200px;">
                <col span="1" style="width: 50px;">
                <col span="1" style="width: 90px;">
                <col span="1" style="width: 200px;">
            </colgroup>
            <thead>
                <tr>
                    <th scope="col" style="text-align: left">Email</th>
                    <th scope="col" style="text-align: left">Full name</th>
                    <th scope="col" style="text-align: left">Program</th>
                    <th scope="col" style="text-align: left">Year</th>
                    <th scope="col" style="text-align: left"></th>
                </tr>
            </thead>
            <tbody>
                
            <c:forEach var="member" items="${applicationScope.members}">
                <tr>
                    <td algin="left">
                        ${member.emailAddress}
                    </td>
                    <td align="left">
                        ${member.fullName}
                    </td>
                    <td align="left">
                        ${member.programName}
                    </td>
                    <td align="left">
                        ${member.yearLevel}
                    </td>
                    <td align="left">
                        <!-- EDIT the action names and values -->
                        <a href="ALNLMemberAdmin?action=editMember&email=${member.emailAddress}" class="greenLink">Edit</a>
                        <a href="ALNLMemberAdmin?action=removeMember&email=${member.emailAddress}" class="greenLink">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    
        <br>
    
        <a href="<c:url value="ALNLMemberAdmin?action=addMember" />" class="buttonStyle">Add Member</a>
   
            
    </div>
    
</div>

<jsp:include page="ALNLFooter.jsp" />