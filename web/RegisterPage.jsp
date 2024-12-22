<%-- 
    Document   : RegisterPage
    Created on : Feb 23, 2023, 7:44:15 PM
    Author     : shlomoyalo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register Form</title>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="allPagesStyle.css">
    </head>
    <body>
        <div class="topnav">
            <div style = "position:fixed; left:765px";>
                <h1>To Do List</h1>
            </div> 
            <a class="active" href="index.html"><img src="LOGO2.jpg" style=width:70px></a>
            <div class="split">
                <a>Hello<br>Guest<br></a>
            </div> 
        </div>
        <div class="downbar">
            <p>
                Shlomo Yalo |<a href= "https://www.netanya.ac.il" target="_blank">Netanya</a>
            </p>   
        </div>
        <h2>Register</h2>
        <h3>Please enter your details:</h3>
        <form method=POST action="registerServ" id="register">
            <div class="modal">
                <label for="email"><b>Email:</b></label>
                    <input type="text" name="email" id="email" placeholder="Enter Email" required>
                <br><br>    
                <label for="Password"><b>Password:</b></label>  
                    <input type="password" name="password" id="password" placeholder="Enter Password" required>
                <br><br>
                <label><b>First Name:</b></label> 
                    <input type="text" name="Fname" id="Fname" placeholder="First name">  
                <br><br>
                <label><b>Last Name:</b> </label>    
                    <input type="text" name="Lname" id="Lname" placeholder="Last name">   
                <br><br>
                <label for="age"><b>Age:</b></label>  
                    <input type="number" name="age" id="age" min="10" max="120">  
                <br><br>
                <!--fix date-->
                <label><b>Birth Day:</b></label>  
                    <input type="Date" name="Bdate" id="Bdate">   
                <br><br>
                <label><b>Gender:</b></label>
                    <form action=\"\">
                        <input class="gendet" type="radio" name="gender" value="male" checked>Male<br>
                        <input class="gendet" type="radio" name="gender" value="female">Female<br>
                    </form>
                <br><br>   
                <input type="checkbox" id="checkbox" value="submit">
                <span>Terms&Privacy</span>    
                <br><br>
                <button type="submit" class="button1" onclick="check()">Register</button>
                <script>
                    function check() {
                        if((document.getElementById("email").value === " " || document.getElementById("password").value === " ")){
                            alert("You must enter email and password");
                            return; 
                        }
                        if(!document.getElementById("checkbox").checked){
                            alert("You must agree to the Terms and Privacy");                        
                        }
                    }
                </script>              
            </div>
        </form>        
    </body>
</html>
