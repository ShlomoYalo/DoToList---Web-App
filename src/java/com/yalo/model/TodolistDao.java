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
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author shlomoyalo
 */
public class TodolistDao {

    private final Connection connection;
    private final TasksDao tasksDao;

    public TodolistDao() throws SQLException, ClassNotFoundException {
        connection = DBUtils.getConnection();
        tasksDao = new TasksDao();
    }


    public void addNewList(ToDoList toDoList) throws SQLException {
        PreparedStatement pStatement;
        pStatement = connection.prepareStatement("insert into TASKS_LIST values (?, ?)");
        pStatement.setString(1, toDoList.getListName());
        pStatement.setString(2, toDoList.getUserEmail());
        pStatement.executeUpdate();
        pStatement.close();
    }

    public ToDoList findToDoListByName(String listName,String username) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM TASKS_LIST WHERE NAME='" + listName + "' AND TASKS_LIST.USER_EMAIL='" + username + "'");
        if(!(resultSet.next())){
            return null;
        }
        ToDoList toDoList = new ToDoList(resultSet.getString("NAME"), resultSet.getString("USER_EMAIL"));
        st.close();
        return toDoList;
    }

    public void removeListFromData(ToDoList toDoList) throws SQLException {
        tasksDao.deleteTasks(toDoList);
        PreparedStatement pt = connection.prepareStatement("DELETE from TASKS_LIST where NAME=? and USER_EMAIL=?");
        pt.setString(1, toDoList.getListName());
        pt.setString(2, toDoList.getUserEmail());
        pt.executeUpdate();
        pt.close();
    }

    public List<ToDoList> findToDoListByName(String email) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM TASKS_LIST WHERE USER_EMAIL='" + email + "'");
        List<ToDoList> list = new ArrayList<>();
        while (resultSet.next()) {
            ToDoList todolist = new ToDoList(resultSet.getString("NAME"), resultSet.getString("USER_EMAIL"));
            List<Task> tasks = tasksDao.findTasks(todolist);
            if (tasks == null) {
                return null;
            }
            for (Task task : tasks) {
                todolist.addTask(task);
            }
            list.add(todolist);
        }
        st.close();
        return list;
    }
}

//FIRST_NAME VARCHAR(200), LAST_NAME VARCHAR(200), EMAIL VARCHAR(200), PASSWORD" + "VARCHAR(200), BIRTH_DATE DATE, AGE INTEGER, GENDER VARCHAR(200))
//CREATE TABLE TASKS_LIST (NAME VARCHAR(200), USER_EMAIL VARCHAR(200))"
