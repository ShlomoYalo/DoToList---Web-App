package com.yalo.servlet;

import com.yalo.model.Task;
import com.yalo.model.TasksDao;
import com.yalo.model.ToDoList;
import com.yalo.model.TodolistDao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shlomoyalo
 */
public class NewTaskServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            TodolistDao todolistDao = new TodolistDao();
            ToDoList toDoList = todolistDao.findToDoListByName(request.getParameter("listName"), (String) request.getSession().getAttribute("userName"));
            TasksDao tasksDao = new TasksDao();
            if (toDoList == null) {
                toDoList = new ToDoList(request.getParameter("listName"), (String) request.getSession().getAttribute("userName"));
                todolistDao.addNewList(toDoList);
                int priority = Integer.parseInt(request.getParameter("priority"));
                String[] dateSplit = request.getParameter("Edate").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                Task newTask = new Task(request.getParameter("taskName"), request.getParameter("description"),priority , date, false,toDoList.getListName(),toDoList.getUserEmail());
                tasksDao.addTask(toDoList, newTask);
                HttpSession session = request.getSession();
                session.setAttribute("nameServ", "newTask");
                response.sendRedirect("/targil4/ControlMessagesPage.jsp");
            }else{
                int priority = Integer.parseInt(request.getParameter("priority"));
                String[] dateSplit = request.getParameter("Edate").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                Task newTask = new Task(request.getParameter("taskName"), request.getParameter("description"), priority, date, false,toDoList.getListName(), toDoList.getUserEmail());
                tasksDao.addTask(toDoList, newTask);
                HttpSession session = request.getSession();
                session.setAttribute("nameServ", "newTask");
                response.sendRedirect("/targil4/ControlMessagesPage.jsp");
            }
        }catch (SQLException | ClassNotFoundException | ParseException ex) {
            Logger.getLogger(NewTaskServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
