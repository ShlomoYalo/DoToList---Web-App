package com.yalo.targail4;

import java.time.LocalDate;

public class User {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final LocalDate date;
    private final int age;
    private String gender;
    

    public User(String firstName, String lastName, String email, String password,LocalDate date,int age,String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.date = date;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    
    public LocalDate getDate() {
        return this.date;
    }
    
    public int getAge() {
        return this.age;
    }
    public String getGender() {
        return this.gender;
    }

}
