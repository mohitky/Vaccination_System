package com.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Registeration {
    public static void register() {
        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

            //connection to Database
            Connection con = ConnectionProvider.getConnection();
            String query1 = "insert into register_vacc(name,age,address,phone,dose_count,vaccine_type,dov) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt1 = con.prepareStatement(query1);

            System.out.print("Enter your Name:");
            String name = sc.readLine();

            System.out.print("Enter your age:");
            int age;
            while (true) {

                age = Integer.parseInt(sc.readLine());

                if (age > 0 && age < 101) {
                    break;
                } else {
                    System.out.print("Oops!!Enter the valid age:");
                }
            }

            System.out.print("Enter your City:");
            String address = sc.readLine();

            System.out.println("Enter 10 digit Phone Number: ");
            String phone;
            String VaccineType;
            while (true) {
                phone = sc.readLine();
                String rege = "\\d{10}";
                // Matching the given phone number with regular expression
                boolean result = phone.matches(rege);
                if (result) {
                    System.out.print("Enter your Vaccine Type from A,B or C: ");
                    VaccineType = sc.readLine();
                    Main.DoseCount++;
                    System.out.println("Congrats! You successfully registered");
                    break;
                } else {
                    System.out.print("Given phone number is not valid\nEnter the valid Number:");
                }
            }
            // Saving Data in database
            pstmt1.setString(1, name);
            pstmt1.setInt(2, age);
            pstmt1.setString(3, address);
            pstmt1.setString(4, phone);
            pstmt1.setInt(5, Main.DoseCount);
            pstmt1.setString(6, VaccineType);
            pstmt1.setDate(7, date);
            pstmt1.executeUpdate();

        } catch (Exception e) {
            System.out.println("Oops!!Something went wrong..");
        }
    }
}
