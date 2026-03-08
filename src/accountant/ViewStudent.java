package accountant;

import database.DBConnection;

import java.sql.*;

public class ViewStudent {

    public static void viewStudent() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from student");

            System.out.println("\nRollNo Name Course Fee Paid Due");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("rollno") + " "
                                + rs.getString("name") + " "
                                + rs.getString("course") + " "
                                + rs.getInt("fee") + " "
                                + rs.getInt("paid") + " "
                                + rs.getInt("due")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}