<%-- 
    Document   : ALNLError
    Created on : Mar 10, 2023, 7:58:29 PM
    Author     : Nikita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/main.css">
        <title>ALNL Computer Programming Club</title>
    </head>
    <body>
        
        <section class="container">
            <jsp:include page="ALNLBanner.jsp" />
            
            <h1>Java Error</h1>
            <p>
                Sorry, Java has thrown an exception.<br>
                To continue, click back button.
            </p>
            
            <h2>Details:</h2>
            <p>Type: ${pageContext.exception["class"]}</p>
            <p>Message: ${pageContext.exception.message}</p>
            <jsp:include page="ALNLFooter.jsp" />
        </section>
         
    </body>
</html>
