package com.beltranbot;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/beltran/IdeaProjects/JavaMasterClass/section_19/TestDB/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("drop table if exists " + TABLE_CONTACTS);
            statement.execute("create table if not exists " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text)");
            insertContact(statement, "Tim", 6545678, "tim@email.com");
            insertContact(statement, "Joe", 45632, "joe@anywhere.com");
            insertContact(statement, "Jane", 4829484, "jane@anywhere.com");
            insertContact(statement, "Fido", 9038, "dog@anywhere.com");

            statement.execute("update " + TABLE_CONTACTS +
                    " set " + COLUMN_PHONE + " = 5566789" +
                    " where " + COLUMN_NAME + "= 'Jane'" );
            statement.execute("delete from " + TABLE_CONTACTS +
                    " where " + COLUMN_NAME + " = 'Joe'");

            ResultSet results = statement.executeQuery("select * from " + TABLE_CONTACTS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL)
                );
            }

            results.close();
            statement.close();
            conn.close(); // order is important
        } catch (SQLException ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException{
        statement.execute("insert into " + TABLE_CONTACTS + "(" +
                COLUMN_NAME + "," +
                COLUMN_PHONE + "," +
                COLUMN_EMAIL + ")" +
                " values ('" + name + "', " + phone + ", '" + email + "')"
        );
    }
}
