package admin;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddAccountant {

    public static void addAccountant() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter contact: ");
            String contact = sc.nextLine();

            Connection con = DBConnection.getConnection();

            String query = "insert into accountant(name,password,email,contact) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, contact);

            ps.executeUpdate();

            System.out.println("Accountant Added Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}