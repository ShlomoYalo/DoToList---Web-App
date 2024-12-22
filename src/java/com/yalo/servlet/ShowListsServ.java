package com.yalo.servlet;

import com.yalo.targail4.Task;
import com.yalo.targail4.TasksDao;
import com.yalo.targail4.ToDoList;
import com.yalo.targail4.ToDoListService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shlomoyalo
 */
public class ShowListsServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO CHECK DELETE LIST
        //TODO FORM RETURN THE SAME TASK NAME
        try {
            TasksDao taskDao = new TasksDao();
            ToDoListService toDoListService = new ToDoListService();
            ToDoList toDoList = toDoListService.findListByName(request.getParameter("listName"), (String) request.getSession().getAttribute("userName"));
            if (request.getParameter("listDone") != null) {
                toDoListService.removeList(toDoList);
            } if (request.getParameter("listDone").trim().equals("delete")) {
                taskDao.deleteTask(request.getParameter("taskName"), request.getParameter("listName"), (String) request.getSession().getAttribute("userName"));
            } else {
                
                taskDao.updateTask(request.getParameter("listName"),
                        request.getParameter("taskName"),
                        (String) request.getSession().getAttribute("userName"), "true".equals(request.getParameter("isDone").trim()));
            }

        } catch (ParseException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ShowListsServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/ShowListsPage.jsp").forward(request, response);
    }

}

/*out.println("<tr style=background-color:" + color + ">\n"
                                + "<td>"+ taskName +"</td>\n"
                                + "<td>"+ taskDes + "</td>\n"
                                + "<td>"+ taskPrio + "</td>\n"
                                + "<td>"+ date + "</td>\n"
                                + "<td>"        
                                + "<form id=" + formID + " method=\"post\">\n"
                                + "<input type=\"hidden\" name=\"listName\" id=\"listName\" value=" + toDoListName + ">\n" 
                                + "<input type=\"hidden\" name=\"taskName\" id=\"taskName\" value=" + taskName + "></form>\n"
                                + "<input type=\"checkbox\" name=\"checkBox\" id=\"checkbox\" value=\"submit\" onclick=\"document.getElementById("+formID+").submit()\">Yes<br>\n"
                                + "</td>\n"  
                                + "</tr>\n");*/
