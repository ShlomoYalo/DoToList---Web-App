
package com.yalo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shlomoyalo
 */
public class ControlMessageServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Messages From</title>\n"
                + "        <link rel=\"stylesheet\" href=\"style.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"allPagesStyle.css\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div class=\"topnav\">\n"
                + "            <div style = \"position:fixed; left:765px;\">\n"
                + "                <h1>To Do List</h1>\n"
                + "            </div> \n"
                + "            <a class=\"active\" href=\"index.html\"><img src=\"LOGO2.jpg\" style=\"width:70px\"></a>\n"
                + "            <div class=\"split\">\n"
                + "                <a>Hello<br>Guest<br></a>\n"
                + "            </div> \n"
                + "        </div>\n"
                + "        <div class=\"downbar\">\n"
                + "            <p>\n"
                + "                Shlomo Yalo |<a href= \"https://www.netanya.ac.il\" target=\"_blank\">Netanya</a>\n"
                + "            </p>\n"
                + "        </div>\n");
        String servName = (String) request.getSession().getAttribute("servtName");
        switch(servName){
            case "login":out.println("<div id =\"myModal\" class=\"modal2\">\n"
                        + "            <div class=\"modal2-content\">\n"
                        + "              <span class=\"close\">&times;</span>\n"
                        + "              <p>Email does not exist</p>\n"
                        + "              <a href= \"index.html\">Back to home page</a>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        <script>\n"
                        + "            var modal2 = document.getElementById(\"myModal\");\n"
                        + "            var span = document.getElementsByClassName(\"close\")[0];\n"
                        + "            modal2.style.display = \"block\";\n"
                        + "            span.onclick = function() {\n"
                        + "                modal2.style.display = \"none\";\n"
                        + "            }\n"
                        + "            window.onclick = function(event) {\n"
                        + "                if (event.target == modal2) {\n"
                        + "                    modal2.style.display = \"none\";\n"
                        + "                }\n"
                        + "            }\n"
                        + "            </script>\n"
                        + "    </body>\n"
                        + "</html>");
            case "register":out.println("<div id =\"myModal\" class=\"modal2\">\n"
                        + "            <div class=\"modal2-content\">\n"
                        + "              <span class=\"close\">&times;</span>\n"
                        + "              <p>Email exists in the system</p>\n"
                        + "              <a href= \"index.html\">Back to home page</a>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        <script>\n"
                        + "            var modal2 = document.getElementById(\"myModal\");\n"
                        + "            var span = document.getElementsByClassName(\"close\")[0];\n"
                        + "            modal2.style.display = \"block\";\n"
                        + "            span.onclick = function() {\n"
                        + "                modal2.style.display = \"none\";\n"
                        + "            }\n"
                        + "            window.onclick = function(event) {\n"
                        + "                if (event.target == modal2) {\n"
                        + "                    modal2.style.display = \"none\";\n"
                        + "                }\n"
                        + "            }\n"
                        + "            </script>\n"
                        + "    </body>\n"
                        + "</html>");
            case "newTask": out.println("<div id =\"myModal\" class=\"modal2\">\n"
                        + "            <div class=\"modal2-content\">\n"
                        + "              <span class=\"close\">&times;</span>\n"
                        + "              <p style=color:green>The Task has been successfully added</p>\n"
                        + "              <a href=\"mainServ.html\">Back to Main</a>\n"
                        + "              <a href=\"newTaskServ.html\">Add another Task</a>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        <script>\n"
                        + "            var modal2 = document.getElementById(\"myModal\");\n"
                        + "            var span = document.getElementsByClassName(\"close\")[0];\n"
                        + "            modal2.style.display = \"block\";\n"
                        + "            span.onclick = function() {\n"
                        + "                modal2.style.display = \"none\";\n"
                        + "            }\n"
                        + "            window.onclick = function(event) {\n"
                        + "                if (event.target == modal2) {\n"
                        + "                    modal2.style.display = \"none\";\n"
                        + "                }\n"
                        + "            }\n"
                        + "            </script>\n"
                        + "    </body>\n"
                        + "</html>");
                break;
    
               
        }
        if (servName == null) {
            out.println("<div id =\"myModal\" class=\"modal2\">\n"
                    + "            <div class=\"modal2-content\">\n"
                    + "              <span class=\"close\">&times;</span>\n"
                    + "              <p style=color:green>Registration was done successfully</p>\n"
                    + "              <a href= \"mainServ.html\">Go to Main page</a>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "        <script>\n"
                    + "            var modal2 = document.getElementById(\"myModal\");\n"
                    + "            var span = document.getElementsByClassName(\"close\")[0];\n"
                    + "            modal2.style.display = \"block\";\n"
                    + "            span.onclick = function() {\n"
                    + "                modal2.style.display = \"none\";\n"
                    + "            }\n"
                    + "            window.onclick = function(event) {\n"
                    + "                if (event.target == modal2) {\n"
                    + "                    modal2.style.display = \"none\";\n"
                    + "                }\n"
                    + "            }\n"
                    + "            </script>\n"
                    + "    </body>\n"
                    + "</html>");
           
        }else{
            if (servName.equals("login")) {
                out.println("<div id =\"myModal\" class=\"modal2\">\n"
                        + "            <div class=\"modal2-content\">\n"
                        + "              <span class=\"close\">&times;</span>\n"
                        + "              <p>Email does not exist</p>\n"
                        + "              <a href= \"index.html\">Back to home page</a>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        <script>\n"
                        + "            var modal2 = document.getElementById(\"myModal\");\n"
                        + "            var span = document.getElementsByClassName(\"close\")[0];\n"
                        + "            modal2.style.display = \"block\";\n"
                        + "            span.onclick = function() {\n"
                        + "                modal2.style.display = \"none\";\n"
                        + "            }\n"
                        + "            window.onclick = function(event) {\n"
                        + "                if (event.target == modal2) {\n"
                        + "                    modal2.style.display = \"none\";\n"
                        + "                }\n"
                        + "            }\n"
                        + "            </script>\n"
                        + "    </body>\n"
                        + "</html>");
            }else{
                if (servName.equals("register")) {
                    out.println("<div id =\"myModal\" class=\"modal2\">\n"
                            + "            <div class=\"modal2-content\">\n"
                            + "              <span class=\"close\">&times;</span>\n"
                            + "              <p>Email Email exists in the system</p>\n"
                            + "              <a href= \"index.html\">Back to home page</a>\n"
                            + "            </div>\n"
                            + "        </div>\n"
                            + "        <script>\n"
                            + "            var modal2 = document.getElementById(\"myModal\");\n"
                            + "            var span = document.getElementsByClassName(\"close\")[0];\n"
                            + "            modal2.style.display = \"block\";\n"
                            + "            span.onclick = function() {\n"
                            + "                modal2.style.display = \"none\";\n"
                            + "            }\n"
                            + "            window.onclick = function(event) {\n"
                            + "                if (event.target == modal2) {\n"
                            + "                    modal2.style.display = \"none\";\n"
                            + "                }\n"
                            + "            }\n"
                            + "            </script>\n"
                            + "    </body>\n"
                            + "</html>");
                }
            }
        } 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
