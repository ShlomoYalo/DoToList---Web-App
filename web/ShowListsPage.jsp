<%-- 
    Document   : ShowListsPage.jsp
    Created on : Feb 25, 2023, 1:42:59 PM
    Author     : shlomoyalo
--%>
<%@page import="com.yalo.targail4.Task"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List;"%>
<%@page import="com.yalo.targail4.ToDoList"%>
<%@page import="com.yalo.targail4.ToDoListService"%>
<%@page import="com.yalo.targail4.TodolistDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show From</title>
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
            <form id="myform3" method= "post">        
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
        <h2>Show To Do List</h2>
        <h3>Your Tasks</h3>
        <%  ToDoListService toDoListService = new ToDoListService();
            List<ToDoList> toDoLists = toDoListService.getListToShow((String) request.getSession().getAttribute("userName"));
            for (ToDoList toDoList : toDoLists) {
                Collections.sort(toDoList.getListTask());
                String toDoListName = toDoList.getListName();%>
        <table id ="table">
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Priority</th>
                <th>End Date</th>
                <th>Task Done</th>
            </tr>
            <%  int index = 0;
                for (Task task : toDoList.getListTask()) {
                    String formID = "myform" + toDoListName + Integer.toString(index);
                    String taskName = task.getTaskName();
                    String taskDes = task.getDescription();
                    String taskPrio = String.valueOf(task.getPriority());
                    String date = task.getDade().getDayOfMonth() + "/" + task.getDade().getMonthValue() + "/" + task.getDade().getYear();
                    String color2 = "white";
                    if (task.getFlag() == true) {
                            color2 = "green";
                        }%>  
            <tr style="background-color: <%=color2%>" >
                <td><%= taskName%></td>
                <td><%= taskDes%></td>
                <td><%= taskPrio%></td>
                <td><%= date%></td>
                <td>        
                    <form id="<%=formID%>" action="showListsServ" method="post">
                        <input type="hidden" name="listName" id="listName" value="<%= toDoListName%>">
                        <input type="hidden" name="taskName" id="taskName" value="<%= taskName%>">
                        <input type="hidden" name="isDone" id="isDone">
                    </form>
                    <input type="checkbox" name="checkBox" id="checkbox" value="submit" <% if (task.getFlag()) {%> checked <%}%>
                           onclick="submit('<%=formID%>')">Yes<br>
                    <form id="<%=formID%>_delete" method= "post">
                        <input type="hidden" name="listName" id="listName" value="<%= toDoListName%>" >
                        <input type="hidden" name="listDone" id="taskName" value="<%= taskName%>">
                        <input type="hidden" name="action" id="action" value="delete">
                    </form>        
                    <button class="deleteButton" form="<%=formID%>_delete" name="delete" value="submit">delete</button>
                    <script>
                    function submit(formID) {
                        if (document.getElementById('checkbox').checked) {
                            document.getElementById("isDone").value = "true";
                        }
                        document.getElementById(formID).submit();
                    }
                    </script>
                </td> 
            </tr>
            <% index++;
                        }%>
            <form id="myform2" method= "post">
                <input type="hidden" name="listName" id="listName" value="<%= toDoListName%>" >
                <input type="hidden" name="listDone" id="listDone" value="delete">
            </form>        
            <button class="button1" form="myform2" name="listDone" value="submit">List Done</button>
            <%}%>        
    </body> 
</html>
