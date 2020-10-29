package com.beltranbot;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/beltran/IdeaProjects/JavaMasterClass/section_19/TestDB/testjava.db");
            Statement statement = conn.createStatement();
//            conn.setAutoCommit(false);
            statement.execute("create table if not exists contacts" +
                    " (name text, phone integer, email text)");
//            statement.execute("insert into contacts (name, phone, email) " +
//                    "values ('Joe', 45362, 'joe@anywhere.com')");
//            statement.execute("insert into contacts (name, phone, email) " +
//                    "values ('Jane', 4829484, 'jane@anywhere.com')");
//            statement.execute("insert into contacts (name, phone, email) " +
//                    "values ('Fido', 9038, 'dog@anywhere.com')");

//            statement.execute("update contacts " +
//                    "set phone = 5566789 " +
//                    "where name='Jane'");

//            statement.execute("delete from contacts " +
//                    "where name = 'Joe'");

            statement.execute("select * from contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email")
                );
            }
            results.close();
            statement.close();
            conn.close(); // order is important
        } catch (SQLException ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }
    }
}
