package com.yalo.targail4;

import java.text.ParseException;
import java.time.LocalDate;

public class Task implements Comparable<Task> {

    private final String name;
    private final String description;
    private final int priority;
    private final LocalDate date;
    private boolean flag;
    private final String listName;
    private final String username;

    public Task(String name, String description, int priority, LocalDate date, boolean flag,String listName,String username) throws ParseException {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.flag = flag;
        this.listName = listName;
        this.username = username;
    }

    public void printTask() {
        System.out.println("Name: " + this.name + "\nDescription: " + this.description + "\npriority: " + this.priority + "\nDate: " + getDade() + "\nDone: " + this.flag);
    }

    @Override
    public int compareTo(Task taskCompare) {
        int comparePriorty = ((Task) taskCompare).getPriority();
        return comparePriorty - this.priority;
    }

    public String getTaskName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPriority() {
        return this.priority;
    }

    public LocalDate getDade() {
        return this.date;
    }

    public boolean getFlag() {
        return this.flag;
    }
    
    public void taskDone(){
        if (this.flag == true) {
            this.flag = false;
        }else{
            this.flag = true;
        }
        
    }
         
}
