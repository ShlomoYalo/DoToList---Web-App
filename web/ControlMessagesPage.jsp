<%-- 
    Document   : ControlMessagesPage
    Created on : Feb 25, 2023, 2:24:06 PM
    Author     : shlomoyalo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%String value = (String) request.getSession().getAttribute("userName");
    if (value == null) {%>
    <jsp:forward page="LoginPage.jsp"/>
    <% }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main From</title>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="allPagesStyle.css">
    </head>
    <body>
        <div class="topnav">
            <div style = "position:fixed; left:765px">
                <h1>To Do List</h1>
            </div> 
            <a class="active" href="mainServ.html"><img src="LOGO2.jpg" style="width:70px"></a>
            <div class="split">
                <% String name = (String) request.getSession().getAttribute("firstName");
                    String gender = (String) request.getSession().getAttribute("gender");
                    String color = "blue";
                    if (gender.equalsIgnoreCase("women")) {
                        color = "pink";
                    }
                %>
                <a style=color:<%=color%> >Hello<br><%=name%><br></a>
            </div>
            <form id="myform2" method= "post">        
                <button style = "position:fixed; right:100px" type="button" class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-log-out"></span> Log out
                </button>       
        </div>
        <div class="downbar">
            <p>
                Shlomo Yalo |<a href= \"https://www.netanya.ac.il\" target="_blank">Netanya</a>
            </p>
        </div>
        <%  String val = (String) request.getSession().getAttribute("servName");%>
            <%if(val == "emailExists"){%>
                <div id ="myModal" class="modal2">
                    <div class="modal2-content">
                        <span class="close">&times;</span>
                        <h2>Email exists in the system</h2>
                        <a href= "index.html">Back to home page</a>
                    </div>
               </div>
            <script>
                var modal2 = document.getElementById("myModal");
                var span = document.getElementsByClassName("close")[0];
                modal2.style.display = "block";
                span.onclick = function() {
                    modal2.style.display = "none";
                }
                window.onclick = function(event) {
                    if (event.target === modal2) {
                        modal2.style.display = "none";
                    }
                }
            </script>
            </body>
            </html>     
            <%}
            if(val == "register"){%>
                <div id = "myModal" class="modal2">
                    <div class="modal2-content">
                        <span class="close">&times;</span>
                        <h2 style=color:green > Registration was done successfully</h2>
                        <a href= "MainPage.jsp">Go to Main page</a>
                    </div>
                </div>
                <script>
                    var modal2 = document.getElementById("myModal");
                    var span = document.getElementsByClassName("close")[0];
                    modal2.style.display = "block";
                    span.onclick = function() {
                        modal2.style.display = "none";
                    }
                    window.onclick = function(event) {
                        if (event.target === modal2) {
                            modal2.style.display = "none"
                        }
                    }
                </script>
            </body>
            </html>
            <%}
            if(val == "emailORpassword"){%>
                <div id ="myModal" class="modal2">
                    <div class="modal2-content">
                        <span class="close">&times;</span>
                        <h2>Incorrect email or password</h2>
                        <a href= "index.html">Back to home page</a>
                    </div>
                </div>
                <script>
                    var modal2 = document.getElementById("myModal");
                    var span = document.getElementsByClassName("close")[0];
                    modal2.style.display = "block";
                    span.onclick = function() {
                        modal2.style.display = "none";
                    }
                    window.onclick = function(event) {
                        if (event.target === modal2) {
                            modal2.style.display = "none";
                        }
                    }
                </script>
               </body>
               </html>)
            <%}
            if(val == "newTask"){%>
                <div id ="myModal" class="modal2">
                    <div class="modal2-content">
                        <span class="close">&times;</span>
                        <h2 style=color:green>The Task has been successfully added</h2>
                        <a href="MainPage.jsp">Back to Main</a>
                        <a href="NewTaskPage.jsp">Add another Task</a>
                    </div>
                </div>
            <script>
                var modal2 = document.getElementById("myModal");
                var span = document.getElementsByClassName("close")[0];
                modal2.style.display = "block";
                span.onclick = function() {
                    modal2.style.display = "none";
                }
                window.onclick = function(event) {
                    if (event.target === modal2) {
                       modal2.style.display = "none";
                    }
                }
            </script>
        </body>
        </html>
        <%} 
        if(val == "listNameExists"){%>
            <div id ="myModal" class="modal2">
                <div class="modal2-content">
                    <span class="close">&times;</span>
                    <h2 style=color:red>The List Exists</h2>
                    <a href="MainPage.jsp">Back to Main</a>
                    <a href="NewListPage.jsp">Try again</a>
                </div>
            </div>
            <script>
                var modal2 = document.getElementById("myModal");
                var span = document.getElementsByClassName("close")[0];
                modal2.style.display = "block";
                span.onclick = function() {
                    modal2.style.display = "none";
                }
                window.onclick = function(event) {
                    if (event.target === modal2) {
                       modal2.style.display = "none";
                    }
                }
            </script>
            </body>
            </html>   
            <%}
            if(val == "listAdded"){%>
            <div id ="myModal" class="modal2">
                <div class="modal2-content">
                    <span class="close">&times;</span>
                    <h2 style=color:green>The list has been successfully added</h2>
                    <a href="MainPage.jsp">Back to Main</a>
                    <br></br>
                    <a href="NewTaskPage.jsp">Add task to the new list</a>
                </div>
            </div>
            <script>
                var modal2 = document.getElementById("myModal");
                var span = document.getElementsByClassName("close")[0];
                modal2.style.display = "block";
                span.onclick = function() {
                    modal2.style.display = "none";
                }
                window.onclick = function(event) {
                    if (event.target === modal2) {
                       modal2.style.display = "none";
                    }
                }
            </script>
            </body>
            </html>   
            <%}%>       
    </body>
</html>
