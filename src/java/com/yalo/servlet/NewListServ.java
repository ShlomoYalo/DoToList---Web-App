
package com.yalo.servlet;

import com.yalo.targail4.ToDoList;
import com.yalo.targail4.TodolistDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shlomoyalo
 */
public class NewListServ extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TodolistDao todolistDao = new TodolistDao();
            if (todolistDao.findToDoListByName(request.getParameter("listName"), (String) request.getSession().getAttribute("userName")) == null) {
                todolistDao.addNewList(new ToDoList(request.getParameter("listName"), (String) request.getSession().getAttribute("userName")));
                HttpSession session = request.getSession();
                session.setAttribute("servName", "listAdded");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ControlMessagesPage.jsp");
                dispatcher.forward(request, response);
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("servName", "listNameExit");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ControlMessagesPage.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewListServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
