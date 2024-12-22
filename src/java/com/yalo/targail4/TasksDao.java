
package com.yalo.targail4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shlomoyalo
 */
public class TasksDao {

    private final Connection connection;

    public TasksDao() throws SQLException, ClassNotFoundException {
        connection = DBUtils.getConnection();
    }

    public void addTask(ToDoList toDoList, Task task) throws SQLException {
        PreparedStatement pStatement;
        pStatement = connection.prepareStatement("insert into TASK values (?, ?, ?, ?, ?, ?, ?)");
        pStatement.setString(1, task.getTaskName());
        pStatement.setString(2, task.getDescription());
        pStatement.setInt(3, task.getPriority());
        java.sql.Date date = java.sql.Date.valueOf(task.getDade());
        pStatement.setDate(4, date);
        pStatement.setBoolean(5, task.getFlag());
        pStatement.setString(6, toDoList.getListName());
        pStatement.setString(7, toDoList.getUserEmail());
        pStatement.executeUpdate();
        pStatement.close();
    }

    public Task findTask(ToDoList toDoList, String taskName) throws SQLException {
        //fix
        String sql = "SELECT * FROM TASK WHERE NAME=? AND LIST_NAME=? AND USER_EMAIL=?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, toDoList.getListName());
        ps.setString(2, taskName);
        ResultSet resultSet = ps.executeQuery();
        if (!resultSet.next()) {
            return null;
        }
        try {
            return createTask(resultSet);
        } catch (ParseException ex) {
            Logger.getLogger(TasksDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Task> findTasks(ToDoList toDoList) throws SQLException {
        String sql = "SELECT * FROM TASK WHERE NAME=? AND USER_EMAIL=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, toDoList.getListName());
        ps.setString(2, toDoList.getUserEmail());
        ResultSet resultSet = ps.executeQuery();
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()) {
            try {
                tasks.add(createTask(resultSet));
            } catch (ParseException ex) {
                Logger.getLogger(TasksDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tasks;
    }

    public void updateTask(String listName, String taskName, String username, boolean done) throws SQLException {
        String sql = "UPDATE TASK set flag = ? WHERE NAME=? AND LIST_NAME=? AND USER_EMAIL=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setBoolean(1, done);
        ps.setString(2, taskName);
        ps.setString(3, listName);
        ps.setString(4, username);
        ps.executeUpdate();
        ps.close();
    }

    private Task createTask(ResultSet resultSet) throws SQLException, ParseException {
        LocalDate date = Instant.ofEpochMilli(resultSet.getDate("DEADLINE").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return new Task(resultSet.getString("NAME"), resultSet.getString("DESCRIPTION"), resultSet.getInt("PRIORITY"), date, resultSet.getBoolean("FLAG"), resultSet.getString("LIST_NAME"), resultSet.getString("USER_EMAIL"));
    }

    public void deleteTasks(ToDoList toDoList) throws SQLException {
        String sql = "DELETE FROM TASK WHERE LIST_NAME=? AND USER_EMAIL=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, toDoList.getListName());
        ps.setString(2, toDoList.getUserEmail());
        ps.close();
    }
    
    public void deleteTask(String taskName,  String listName, String username) throws SQLException {
        String sql = "DELETE FROM TASK WHERE LIST_NAME=? AND USER_EMAIL=? AND NAME=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, listName);
        ps.setString(2, username);
        ps.setString(2, taskName);
        ps.close();
    }
}

//FIRST_NAME VARCHAR(200), LAST_NAME VARCHAR(200), EMAIL VARCHAR(200), PASSWORD" + "VARCHAR(200), BIRTH_DATE DATE, AGE INTEGER, GENDER VARCHAR(200))
//CREATE TABLE TASKS_LIST (NAME VARCHAR(200), USER_EMAIL VARCHAR(200))"
//"CREATE TABLE TASK (NAME VARCHAR(200), DESCRIPTION VARCHAR(200), PRIORITY INTEGER, DEADLINE DATE,FLAG BOOLEAN, LIST_NAME VARCHAR(200), USER_EMAIL VARCHAR(200),"" PRIMARY KEY (NAME,LIST_NAME,USER_EMAIL),"" FOREIGN KEY (USER_EMAIL) REFERENCES USERS(EMAIL),FOREIGN KEY (LIST_NAME,USER_EMAIL) REFERENCES TASKS_LIST(NAME,USER_EMAIL))"
