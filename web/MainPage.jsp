<%-- 
    Document   : MainPage
    Created on : Feb 25, 2023, 11:29:04 AM
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
    </head>
    <body>
        <div class="topnav">
            <div style = "position:fixed; left:765px">
                <h1>To Do List</h1>
            </div> 
            <a class="active" href="mainServ.html"><img src="LOGO2.jpg" style="width:70px"></a>
            <div class="split">
            <% String name = (String)request.getSession().getAttribute("firstName");
               String gender = (String)request.getSession().getAttribute("gender");
               String color = "blue";
               if(gender.equalsIgnoreCase("women")){
                    color = "pink";
                }
            %>
            <a style=color:<%=color%> >Hello<br><%=name%><br></a>
            </div>
            <form id="myform2" method= "post">        
                <button style = "position:fixed; right:100px" type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-log-out"></span> Log out
                </button>
            </form>    
        </div>
        <div class="downbar">
            <p>
                Shlomo Yalo |<a href= \"https://www.netanya.ac.il\" target="_blank">Netanya</a>
            </p>
        </div>
        <h2>Welcome to main page</h2>
        <h3>What would you like to do?</h3>
        <form method=POST id="main">
            <div class="flex-container">
                <p>
                    <a href="NewTaskPage.jsp">Add New Task</a>
                <br><br>
                    <a href="NewListPage.jsp">Add New To Do List</a>
                <br><br>
                    <a href="ShowListsPage.jsp">Show To Do List</a>
                </p>
            </div>
        </form>
    </body>
</html
