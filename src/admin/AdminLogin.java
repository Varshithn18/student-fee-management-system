package admin;

import database.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class AdminLogin {

    public static void adminLogin() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        try {

            Connection con = DBConnection.getConnection();

            String query = "select * from admin where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Login Successful");
                AdminMenu.adminMenu();

            } else {

                System.out.println("Invalid Credentials");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}