package com.yalo.servlet;


import com.yalo.targail4.User;
import com.yalo.targail4.UsersDao;
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
public class LoginServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((String)request.getSession().getAttribute("userName") != null) {
            response.sendRedirect("/targil4/mainServ.html");
        }
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsersDao  userDao = new UsersDao();
            if (userDao.checkingUserLogin(request.getParameter("Uname"), request.getParameter("Pass"))){
                User user = userDao.findUserByEmail(request.getParameter("Uname"));
                //TODO if password is null
                //TODO error message in home page if email or password incorrect
                HttpSession session = request.getSession();
                String value = request.getParameter("Uname");
                session.setAttribute("user", user);
                session.setAttribute("userName", value);
                session.setAttribute("firstName", user.getFirstName());
                session.setAttribute("gender", user.getGender());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MainPage.jsp");
                dispatcher.forward(request, response);
            }else{
                HttpSession session2 = request.getSession();
                String value2 = "emailORpassword";
                session2.setAttribute("servtName", value2);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ControlMessagesPage.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
