<%-- 
    Document   : ALNLAdmin
    Created on : Feb 9, 2023, 5:41:45 p.m.
    Authors     :  Alfredo Lozano, Nikita Litvinov
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ALNLBanner.jsp" />
        
            <h1>Admin : Data Maintenance</h1>
            
            <div class="adminBookLink">
                <a href="ALNLDisplayBooks">Maintain Books</a>
            </div>
            
            <div class="adminBookLink">
                <a href="<c:url value="ALNLMemberAdmin?action=displayMembers"/>">Display Members</a>
            </div>
        
 <jsp:include page="ALNLFooter.jsp" />