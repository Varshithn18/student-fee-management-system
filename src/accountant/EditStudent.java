package accountant;

import database.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class EditStudent {

    public static void editStudent() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();

            System.out.print("Enter new paid fee: ");
            int paid = sc.nextInt();

            Connection con = DBConnection.getConnection();

            String query1 = "select fee from student where rollno=?";
            PreparedStatement ps1 = con.prepareStatement(query1);

            ps1.setInt(1, roll);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                int fee = rs.getInt("fee");
                int due = fee - paid;

                String query2 = "update student set paid=?, due=? where rollno=?";
                PreparedStatement ps2 = con.prepareStatement(query2);

                ps2.setInt(1, paid);
                ps2.setInt(2, due);
                ps2.setInt(3, roll);

                ps2.executeUpdate();

                System.out.println("Student Updated");

            } else {

                System.out.println("Student not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}