package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            if (con == null || con.isClosed()) {

                String url = "jdbc:postgresql://192.168.2.47:5432/Freshers_Training";
                String user = "freshers_training_user";
                String password = "Appzillon@001";

                Class.forName("org.postgresql.Driver");

                con = DriverManager.getConnection(url, user, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}