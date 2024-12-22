package com.yalo.targail4;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class Login {

    private final Data dataSource;

    public Login() throws IOException, ParseException {
        this.dataSource = Data.getData();
    }

    public void Register(String firstName, String lastName, String email, String password,LocalDate date,int age,String gender) throws IOException {
       
    }

    public boolean emailExists(String email) {
        User u = dataSource.findUserByEomail(email);
        return u != null;
    }

    public User getUserByEmail(String email) {
        return dataSource.findUserByEomail(email);
    }

}
