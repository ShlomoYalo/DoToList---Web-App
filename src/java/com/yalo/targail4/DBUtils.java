package com.yalo.targail4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shlomoyalo
 */
public class DBUtils {

    private static Connection connection;

    private DBUtils() throws SQLException, ClassNotFoundException {
        connection = getConnection();
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection != null) {
            return connection;
        }
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/todolist", "root", "root");
        createSechemaIfNeeded();
        return connection;
    }

    private static void createSechemaIfNeeded() throws SQLException {
        Statement st = connection.createStatement();
        try {
            st.executeQuery("SELECT * from TASK");
        } catch (SQLException e) {
            st.executeUpdate("CREATE TABLE USERS "
                    + "(FIRST_NAME VARCHAR(200), LAST_NAME VARCHAR(200), EMAIL VARCHAR(200), PASSWORD VARCHAR(200), BIRTH_DATE DATE, AGE INTEGER, GENDER VARCHAR(200),PRIMARY KEY(EMAIL))");
            st.executeUpdate("CREATE TABLE TASKS_LIST (NAME VARCHAR(200), USER_EMAIL VARCHAR(200), PRIMARY KEY(NAME,USER_EMAIL),FOREIGN KEY(USER_EMAIL) REFERENCES USERS(EMAIL)) ");
            st.executeUpdate("CREATE TABLE TASK (NAME VARCHAR(200), DESCRIPTION VARCHAR(200), PRIORITY INTEGER, DEADLINE DATE,FLAG BOOLEAN, LIST_NAME VARCHAR(200), USER_EMAIL VARCHAR(200),"
                    + " PRIMARY KEY (NAME,LIST_NAME,USER_EMAIL),"
                    + " FOREIGN KEY (USER_EMAIL) REFERENCES USERS(EMAIL),FOREIGN KEY (LIST_NAME,USER_EMAIL) REFERENCES TASKS_LIST(NAME,USER_EMAIL))");
        }
    }

}
