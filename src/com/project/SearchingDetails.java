package com.project;

import java.sql.*;
import java.util.Scanner;

public class SearchingDetails {

    public static void search() throws SQLException {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        Scanner input = new Scanner(System.in);
        Connection con = ConnectionProvider.getConnection();
        String query2 = "select * from register_vacc WHERE phone=" + Main.phone;
        PreparedStatement pstmt2 = con.prepareStatement(query2);

        ResultSet set = pstmt2.executeQuery(query2);

        set.next();
        String name = set.getString(1);
        int age = set.getInt(2);
        String address = set.getString(3);
        int dose_count = set.getInt(5);

        System.out.println("\nSearched Details:");
        System.out.println("\nName : " + name);
        System.out.println("Age : " + age);
        System.out.println("Address : " + address);
        System.out.println("Number of Dose : " + dose_count);

        System.out.print("\nDo you want to take your Next Dose:\nEnter 'Y' for Yes OR 'N' for No: ");
        while (true) {
            char NextDose = input.next().charAt(0);

            if (NextDose == 'Y' || NextDose == 'y') {
                if (dose_count == 4) {
                    System.out.println("\nSORRY! You have already completed your doses");
                    break;
                }

                dose_count++;
                // Query for Data updation in Database
                String query3 = "update register_vacc set dose_count=?,dov=? where phone=?";
                PreparedStatement pstmt3 = con.prepareStatement(query3);
                pstmt3.setInt(1, dose_count);
                pstmt3.setDate(2, date);
                pstmt3.setString(3, Main.phone);
                pstmt3.executeUpdate();
                break;
            } else if (NextDose == 'N' || NextDose == 'n') {
                break;
            } else {
                System.out.print("Please...Enter the valid input:");
            }
        }
              // Vaccine_Details
        System.out.println("\nVaccination Details:");
        System.out.println("Registered Mobile Number: " + Main.phone);
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Address : " + address);
        System.out.println("Number of Dose : " + dose_count);
        String VaccType = set.getString(6);
        Date date2 = set.getDate(7);
        System.out.println("Latest Vaccine Date: " + date2);
        System.out.println("Type of Vaccine: " + VaccType);

    }

}



