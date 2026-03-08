package accountant;

import java.sql.*;
import java.util.Scanner;
import database.DBConnection;

public class AddStudent {

    public static void addStudent() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            System.out.print("Total Fee: ");
            int fee = sc.nextInt();

            System.out.print("Paid Fee: ");
            int paid = sc.nextInt();

            int due = fee - paid;
            sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("City: ");
            String city = sc.nextLine();

            System.out.print("State: ");
            String state = sc.nextLine();

            System.out.print("Country: ");
            String country = sc.nextLine();

            System.out.print("Contact: ");
            String contact = sc.nextLine();

            Connection con = DBConnection.getConnection();

            String query = "insert into student(name,email,course,fee,paid,due,address,city,state,country,contact) values(?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, fee);
            ps.setInt(5, paid);
            ps.setInt(6, due);
            ps.setString(7, address);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setString(10, country);
            ps.setString(11, contact);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}