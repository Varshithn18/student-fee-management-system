import java.sql.*;
import java.util.Scanner;
import admin.AdminLogin;
import accountant.AccountantLogin;
import database.DBConnection;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== FEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Accountant Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    AdminLogin.adminLogin();
                    break;

                case 2:
                    AccountantLogin.accountantLogin();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}