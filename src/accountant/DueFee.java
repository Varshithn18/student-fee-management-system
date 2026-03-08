package accountant;

import database.DBConnection;

import java.sql.*;

public class DueFee {

    public static void showDueFee() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from student where due>0");

            System.out.println("\nStudents With Due Fee:");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("rollno") + " "
                                + rs.getString("name") + " "
                                + rs.getInt("due")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}