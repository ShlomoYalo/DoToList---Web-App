<%-- 
    Document   : LoginPage
    Created on : Feb 23, 2023, 6:19:28 PM
    Author     : shlomoyalo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Form</title>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="allPagesStyle.css">
    </head>
    <body>
    <div class="topnav">
        <div style = "position:fixed; left:765px;">
            <h1>To Do List</h1>
        </div> 
        <a class="active" href="index.html"> <img src="LOGO2.jpg" style=width:70px></a>
        <div class="split">
            <a>Hello<br>Guest<br></a>
        </div> 
    </div>
    <div class="downbar">
        <p>
            Shlomo Yalo |<a href= \"https://www.netanya.ac.il\" target="_blank">Netanya</a>
        </p>
    </div>
    <h2>Login</h2>
    <h3> Please enter details:</h3> 
    <form method=POST action="loginServlet" id="login">
        <div class="modal">
            <label><b>User Name:</b></label>   
            <input type="text" name="Uname" id="Uname" placeholder="Username" required>
            <br><br> 
            <label><b>Password:</b></label>   
            <input type="password" name="Pass" id="Pass" placeholder="Password" required>
            <br><br>  
            <button type="submit" onclick= "loginServlet" class="button1">Login</button>
            <br><br> 
            <!-- <input type=\"checkbox\" id=\"check\">    \n"
            <span>Remember me</span>\n"
            <br><br>--> 
            <div class="tooltip">
                <div class = "tooltip"> <a href="index.html">Forgot Password</a>
                    <span class="tooltiptext">To reset your password, we will send you a reset link to your email.</span>  
                </div>
            </div>
        </div>    
    </form>    
    </body>
</html>"