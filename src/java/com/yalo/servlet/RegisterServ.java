package com.yalo.servlet;

import com.yalo.targail4.Login;
import com.yalo.targail4.User;
import com.yalo.targail4.UsersDao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
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
public class RegisterServ extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            UsersDao usersDao;
            //TODO error message in home page if email exists
            try {
                usersDao = new UsersDao();
                if (usersDao.emailExists(request.getParameter("email"))) {
                    HttpSession session2 = request.getSession();
                    String value2 = "emailExit";
                    session2.setAttribute("servtName", value2);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ControlMessagesPage.jsp");
                    dispatcher.forward(request, response);
                } else {
                    String[] dateSplit = request.getParameter("Bdate").split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                    User user = new User(request.getParameter("Fname"), request.getParameter("Lname"), request.getParameter("email"), request.getParameter("password"), date, Integer.parseInt(request.getParameter("age")), request.getParameter("gender"));
                    usersDao.addUser(user);
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", request.getParameter("email"));
                    session.setAttribute("firstName", request.getParameter("Fname"));
                    session.setAttribute("gender", request.getParameter("gender"));
                    session.setAttribute("servName", "register");
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ControlMessagesPage.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RegisterServ.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       
    }
}
