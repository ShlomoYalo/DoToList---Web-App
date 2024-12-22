/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yalo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shlomoyalo
 */
public class UsersDao {

private final Connection connection; 

 public UsersDao() throws SQLException, ClassNotFoundException {
      connection = DBUtils.getConnection();
 }
 
    public void addUser(User user) {
        
    try {
        PreparedStatement pStatement;
        pStatement = connection.prepareStatement("insert into users values (?, ?, ?, ?, ?, ? ,? )");
        pStatement.setString(1, user.getFirstName());
        pStatement.setString(2, user.getLastName());
        pStatement.setString(3, user.getEmail());
        pStatement.setString(4, user.getPassword());
        java.sql.Date date = java.sql.Date.valueOf(user.getDate());
        pStatement.setDate(5, date);
        pStatement.setInt(6, user.getAge());
        pStatement.setString(7, user.getGender());
        pStatement.executeUpdate();
        pStatement.close();
    } catch (SQLException ex) {
        Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public User findUserByEmail(String email) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM userS WHERE email='" + email + "'");
        if (!resultSet.next()) {
            return null;
        }
        LocalDate localDate = Instant.ofEpochMilli(resultSet.getDate("BIRTH_DATE").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        User user = new User(resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), resultSet.getString("EMAIL"), resultSet.getString("PASSWORD"), localDate, Integer.parseInt(resultSet.getString("AGE")), resultSet.getString("GENDER"));
        st.close();
        return user;
    }
    
    public boolean emailExists(String email) throws SQLException{
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM userS WHERE email='" + email + "'");
        boolean flag = resultSet.next();
        st.close();
        return flag;    
    }
    
    public boolean checkingUserLogin(String username,String password) throws SQLException{
        if(emailExists(username)){
            User user = findUserByEmail(username);
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
   
}



//FIRST_NAME VARCHAR(200), LAST_NAME VARCHAR(200), EMAIL VARCHAR(200), PASSWORD" + "VARCHAR(200), BIRTH_DATE DATE, AGE INTEGER, GENDER VARCHAR(200))
//CREATE TABLE TASKS_LIST (NAME VARCHAR(200), USER_EMAIL VARCHAR(200))"
