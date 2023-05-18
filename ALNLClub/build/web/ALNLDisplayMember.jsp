<%-- 
    Document   : ALNLDisplayMember
    Created on : Feb 9, 2023, 10:08:23 PM
    Author     : Alfredo Lozano and Nikita Litvinov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALNL Programming Club</title>
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <section class="container">
            <jsp:include page="ALNLBanner.jsp" />
        
            <div class="displayMember">
                <h2>Thanks for joining our club!</h2>               
                
                <p style="font-weight: normal"> Here is the information you entered:</p>
                
                <div class="memberInfo">
                    <p>Full name:</p> 
                    <span>${param.fullName}</span>
                </div>
                
                <div class="memberInfo">
                    <p>Email:</p>
                    <span>${param.email}</span>
                </div>
                
                <div class="memberInfo">
                    <p>Phone:</p>
                    <span>${param.phoneNum}</span>
                </div>
                
                <div class="memberInfo">
                    <p>IT Program:</p>
                    <span>${param.itProgram}</span>
                </div>
                
                <div class="memberInfo">
                    <p>Year level:</p>
                    <span>${param.yearLvl}</span>
                </div>
            
                <p style="font-weight: normal">To register another member, click on the Back button in your browser or <br>
                the Return button shown below. </p>            
            
                <form action="/ALNLClub" method="get">
            
                <input type="submit" id="button" value="Return" >
            </div>
        
            <jsp:include page="ALNLFooter.jsp" />
        </section>
    </body>
</html>
