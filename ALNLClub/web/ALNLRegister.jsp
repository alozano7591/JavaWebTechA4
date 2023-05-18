<%-- 
    Document   : ALNLRegister
    Created on : Feb 7, 2023, 2:32:44 p.m.
    Author     : Alfredo Lozano and Nikita Litvinov
--%>

    <jsp:include page="ALNLBanner.jsp" />

    <h2>New Member Registration Form</h2>

    <div class="stForm">
        <form action="ALNLDisplayMember.jsp" method="post">

            <li class="form-row">
                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" required><br>
            </li>

             <li class="form-row">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br>
            </li>

            <li class="form-row">
                <label for="phoneNum">Phone:</label>
                <input type="phone" id="phoneNum" name="phoneNum" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required><br>
            </li>

            <li class="form-row">
                <label for="itProgram">IT Program:</label>
                <select id="itProgram" name="itProgram">
                    <option value="CAS">CAS</option>
                    <option value="SQATE">SQATE</option>
                    <option value="CPA">CPA</option>
                    <option value="CP">CP</option>
                    <option value="ITID">ITID</option>
                    <option value="CAD">CAD</option>
                    <option value="ITSS">ITSS</option>
                </select><br>
            </li>

            <li class="form-row">
                <label for="yearLvl">Year Level:</label>
                <select type="number" id="yearLvl" name="yearLvl">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select><br>
            </li>    
            
            <div><!-- comment -->
                <input type="submit" id="button" value="Register Now!">
                <input type="reset" id="button" value="Reset">
            </div>
            
        </form>
    </div>



    <jsp:include page="ALNLFooter.jsp" />
