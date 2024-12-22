package com.yalo.targail4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList  {

    private final String listName;
    private final String userEmail;
    private final List<Task> tasks;

    public ToDoList(String lisName,String username) {
        this.listName = lisName;
        this.userEmail = username;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void deleteTask(int indexTask) {
        tasks.remove(indexTask);
    }

    public void showDetails() {
        Collections.sort(tasks);
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println(i + 1 + ")");
            this.tasks.get(i).printTask();
        }
    }

    public int getTodoListSize() {
        return tasks.size();
    }

    public String getListName() {
        return this.listName;
    }

    public String getUserEmail() {
        return userEmail;
    }
    
    public List<Task> getListTask() {
        return tasks;
    }
    
}
