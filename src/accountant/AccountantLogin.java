package accountant;

import database.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class AccountantLogin {

    public static void accountantLogin() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        try {

            Connection con = DBConnection.getConnection();

            String query = "select * from accountant where email=? and password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Login Successful");
                AccountantMenu.menu();

            } else {

                System.out.println("Invalid credentials");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}