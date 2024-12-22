<%-- 
    Document   : NewTaskPage.jsp
    Created on : Feb 25, 2023, 12:47:24 PM
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
            </form>    
        </div>
        <div class="downbar">
            <p>
                Shlomo Yalo |<a href= \"https://www.netanya.ac.il\" target="_blank">Netanya</a>
            </p>
        </div>
        <h2>Adding a new Task</h2>
        <h3>Fill the task details</h3>
        <form method=POST action="newTaskServ" id="Task">
            <div class="modal">
                <label>List Name:</label>
                    <input type="text" name="listName" id="listName" placeholder="List Name" required>
                <br><br>                   
                <label>Task Name:</label>
                    <input type="text" name="taskName" id="taskName" placeholder="Task Name" required>
                <br><br>
                <label>Description:</label>
                    <input type="text" name="description" id="description" placeholder="Description" maxlength="100">
                    <!-- <a href="../src/java/com/yalo/servlet/ControlMessageServ.java"></a>t -->
                <br><br>
                <label>Priority</label>
                    <input type="number" name="priority" id="Priority" placeholder="Priority" min="1" max="3" >
                <br><br>
                <label>End Date</label>
                    <input type="date" name="Edate" id="Edate" placeholder="End Date" >
                <br><br>
                <button type="submit" onclick="newTaskServ" class="button1">Add Task</button> 
            </div>
        </form>
    </body>
</html>    
   
