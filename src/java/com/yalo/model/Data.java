package com.yalo.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private final List<User> users;
    private final List<ToDoList> toDoLists;
    private static Data data;

    private Data() throws IOException, ParseException {
        users = new ArrayList<>();
        toDoLists = new ArrayList<>();
        loadTodoList();
        loadUsers();
        

    }

    public static Data getData() throws IOException, ParseException {
        if (data != null) {
            return data;
        }
        data = new Data();
        return data;
    }

    private void loadUsers() throws IOException {
        File usersFile = new File("users.txt");
        if (!usersFile.exists()) {
            return;
        }
        FileReader fileReader = new FileReader(usersFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line != null) {
            String[] userParts = line.split(",");
            String[] dateSplit = userParts[4].split("-");
            LocalDate date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
            line = reader.readLine();
            User user = new User(userParts[0], userParts[1], userParts[2], userParts[3], date, Integer.parseInt(userParts[5]),userParts[6]);
            users.add(user);
        }
    }

    private void loadTodoList() throws IOException {
        File toDoListsFile = new File("ToDoLists.txt");
        if (!toDoListsFile.exists()) {
            return;
        }
        FileReader fileReader = new FileReader(toDoListsFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line != null) {
            //toDoLists.add(new ToDoList(line));
            line = reader.readLine();
        }
    }

   

    public User findUserByEomail(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (email.toLowerCase().equals(users.get(i).getEmail().toLowerCase())) {
                return users.get(i);
            }
        }
        return null;
    }

    
    private void saveUsersIntoFile() throws IOException {
        File usersFile = new File("users.txt");
        if (!usersFile.exists()) {
            try {
                usersFile.createNewFile();
            } catch (Exception e) {
                System.err.println(String.format("Failed to create File: `%s`", usersFile.getAbsoluteFile()));
                return;
            }
        }
        FileWriter fw = new FileWriter(usersFile);
        for (User user : users) {
            
            fw.write((user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + "," + user.getPassword()+","+ user.getDate()+","+ user.getAge()+ "," + user.getGender()) + System.lineSeparator());
        }
        fw.close();
    }

    public void addToDoList(ToDoList addList) throws IOException {
        toDoLists.add(addList);
        saveToDoListsIntoFile();
    }

    private void saveToDoListsIntoFile() throws IOException {
        File ToDoListsFile = new File("ToDoLists.txt");
        if (!ToDoListsFile.exists()) {
            try {
                ToDoListsFile.createNewFile();
            } catch (IOException e) {
                System.err.println(String.format("Failed to create File: `%s`", ToDoListsFile.getAbsoluteFile()));
                return;
            }
        }
        FileWriter toDoListWriter = new FileWriter(ToDoListsFile);
        for (ToDoList list : toDoLists) {
            toDoListWriter.write(list.getListName() + System.lineSeparator());
        }
        toDoListWriter.close();
    }

    public ToDoList findToDoListByName(String listName) {
        for (ToDoList list : toDoLists) {
            if (list.getListName().equalsIgnoreCase(listName)) {
                return list;
            }
        }
        return null;
    }

    public void saveTaskListIntoFile() throws IOException {
        File taksListFile;
        for (ToDoList list : toDoLists) {
            taksListFile = new File(findToDoListByName(list.getListName()).getListName() + ".txt");
            if (!taksListFile.exists()) {
                try {
                    taksListFile.createNewFile();
                } catch (IOException e) {
                    System.err.println(String.format("Failed to create File: `%s`", taksListFile.getAbsoluteFile()));
                    return;
                }
            }
            FileWriter fw2 = new FileWriter(taksListFile);
            for (Task task : list.getListTask()) {
                fw2.write(task.getTaskName() + "," + task.getDescription() + "," + task.getPriority() + "," + task.getDade() + "," + task.getFlag() + System.lineSeparator());
            }
            fw2.close();
        }

    }

    public void removeToDoListFromList(ToDoList toDoList) throws IOException {
        int temp = 0;
        for (ToDoList List : toDoLists) {
            if (List.getListName().equals(toDoList.getListName())) {
                toDoLists.remove(temp);
                saveToDoListsIntoFile();
                saveTaskListIntoFile();
                deleteToDoListFile(toDoList);

                return;
            } else {
                temp++;
            }
        }
    }

    private void deleteToDoListFile(ToDoList toDoList) {
        File deleteFile = new File(toDoList.getListName() + ".txt");
        deleteFile.delete();
        //TODO MESSAGE THAT LIST DELETED
    }

    public void showToDoLists() {
        for (ToDoList list : toDoLists) {
            System.out.println(list.getListName());
        }
    }

    public void showTaksDetails(ToDoList toDoList) {
        toDoList.showDetails();
    }

    public void removeTask(ToDoList toDoList, int taskIndex) throws IOException {
        int index = taskIndex - 1;
        toDoList.deleteTask(index);
        saveToDoListsIntoFile();
        saveTaskListIntoFile();
        System.out.println("Task Update");
    }

    public List<ToDoList> getToDoListsByName(String email) {
        List<ToDoList> listsByNames = new ArrayList<>();
        for (ToDoList toDoList : toDoLists) {
            String[] listName = toDoList.getListName().split("\\$");
            if(listName[1].equals(email)){
                listsByNames.add(toDoList);
            }
        }
        return  listsByNames;
    } 
}
