<%-- 
    Document   : ALNLLoan
    Created on : Mar 31, 2023, 12:33:31 a.m.
    Author     : Alfredo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="ALNLBanner.jsp" />

    <div class="loansTable">
            
        <table >
            <colgroup>
                <col span="1" style="width: 50px;">
                <col span="1" style="width: 300px;">
                <col span="1" style="width: 50px;">
                <col span="1" style="width: 90px;">
            </colgroup>
            <thead>
                <tr>
                    <th scope="col" style="text-align: left">Code</th>
                    <th scope="col" style="text-align: left">Description</th>
                    <th scope="col" style="text-align: left">QOH</th>
                    <th scope="col" style="text-align: left">Action</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${applicationScope.loanItems}">
                <tr>
                    <td align="left">
                        ${item.code}
                    </td>
                    <td algin="left">
                        ${item.description}
                    </td>
                    <td align="left">
                        <c:if test="${item.quantity > 0}">
                            ${item.quantity}
                        </c:if>
                        <c:if test="${item.quantity < 1}">
                            0
                        </c:if>
                    </td>
                    <td align="left">
                        <c:if test="${item.quantity >= 1}">
                            <a href="<c:url value="ALNLCart?action=reserve&code=${item.code}" />">Reserve</a>
                        </c:if>
                        <c:if test="${item.quantity < 1}">
                            N/A
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            
    </div>
        
<jsp:include page="ALNLFooter.jsp" />
            
<%--
        </section>
    </body>
</html>
--%>