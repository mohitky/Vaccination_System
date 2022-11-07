package com.project;

import java.sql.*;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection(){
        try {
            if (con == null) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                // Change user_name and password ....with your respective database user name and password
                String user_name = "root";
                String password = "root";
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vaccineproject",user_name,password);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}

