package com.beltranbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/beltran/IdeaProjects/JavaMasterClass/section_19/TestDB/testjava.db");
            Statement statement = conn.createStatement();
            statement.execute("create table contacts (name text, phone integer, email text)");
            statement.close();
            conn.close(); // order is important
        } catch (SQLException ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }
    }
}
