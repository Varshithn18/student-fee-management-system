package accountant;

import database.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class EditStudent {

    public static void editStudent() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Roll Number: ");
            int roll = Integer.parseInt(sc.nextLine());

            Connection con = DBConnection.getConnection();

            String query1 = "select * from student where rollno=?";
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setInt(1, roll);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String course = rs.getString("course");
                int fee = rs.getInt("fee");
                int paid = rs.getInt("paid");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String country = rs.getString("country");
                String contact = rs.getString("contact");

                System.out.println("\nPress Enter to keep current value\n");

                System.out.print("Name (" + name + "): ");
                String input = sc.nextLine();
                if (!input.isEmpty()) name = input;

                System.out.print("Email (" + email + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) email = input;

                System.out.print("Course (" + course + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) course = input;

                System.out.print("Fee (" + fee + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) fee = Integer.parseInt(input);

                System.out.print("Paid (" + paid + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) paid = Integer.parseInt(input);

                System.out.print("Address (" + address + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) address = input;

                System.out.print("City (" + city + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) city = input;

                System.out.print("State (" + state + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) state = input;

                System.out.print("Country (" + country + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) country = input;

                System.out.print("Contact (" + contact + "): ");
                input = sc.nextLine();
                if (!input.isEmpty()) contact = input;

                int due = fee - paid;

                String query2 =
                    "update student set name=?, email=?, course=?, fee=?, paid=?, due=?, address=?, city=?, state=?, country=?, contact=? where rollno=?";
                PreparedStatement ps2 = con.prepareStatement(query2);

                ps2.setString(1, name);
                ps2.setString(2, email);
                ps2.setString(3, course);
                ps2.setInt(4, fee);
                ps2.setInt(5, paid);
                ps2.setInt(6, due);
                ps2.setString(7, address);
                ps2.setString(8, city);
                ps2.setString(9, state);
                ps2.setString(10, country);
                ps2.setString(11, contact);
                ps2.setInt(12, roll);

                ps2.executeUpdate();

                System.out.println("\nStudent Updated Successfully");
            } else {
                System.out.println("Student not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
