package com.yalo.targail4;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ToDoListService {

    private final TodolistDao todolistDao;

    public ToDoListService() throws IOException, ParseException, SQLException, ClassNotFoundException {
        this.todolistDao = new TodolistDao();
    }

    public ToDoList findListByName(String listName,String username) throws SQLException {
        return todolistDao.findToDoListByName(listName,username);
    }

    public void addNewList(ToDoList toDoList) throws IOException, SQLException {
        todolistDao.addNewList(toDoList);
    }

    public void removeList(ToDoList toDoList) throws IOException, SQLException {
        todolistDao.removeListFromData(toDoList);
    }

    /*public void showListNames() {
        System.out.println("To Do Lists names:");
        todolistDao.showToDoLists();
    }

    public void showTaksFromTheList(ToDoList showToDoList) {
        todolistDao.showTaksDetails(showToDoList);
    }

    public void saveTaksList() throws IOException {
        todolistDao.saveTaskListIntoFile();
    }

    public void taskUpdate(ToDoList toDoList, int taskIndex) throws IOException {
        todolistDao.removeTask(toDoList, taskIndex);
    }*/
    
    public List<ToDoList> getListToShow(String email) throws SQLException{
        return todolistDao.findToDoListByName(email);
    }
}

