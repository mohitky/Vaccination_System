package com.project;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static int DoseCount;
    public static String phone;

    public static void main(String[] args) throws IOException, SQLException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        System.out.println("\n.....Vaccination System.....");

        while (true) {
                // Taking input for further execution
                System.out.println("Press 1 for Registration");
                System.out.println("Press 2 for Searching");
                System.out.println("Press 9 for exit");
                int c;
                while (true) {
                    c = Integer.parseInt(sc.readLine());
                    if (!(c == 1 || c == 2 || c == 9)) {
                        System.out.print("Enter the valid option: ");
                    } else {
                        break;
                    }
                }
                if(c==1){
                    //Registration...
                     Registeration.register();
                }
                else if(c==2){
                    //Searching...
                    System.out.print("\nEnter your Registered Mobile Number:");
                    phone = sc.readLine();
                    SearchingDetails.search();
                }
                else if (c == 9) {
                    System.out.println("....Thanks for visiting....");
                    break;
                }

            System.out.println("\n");
        }
    }
}

