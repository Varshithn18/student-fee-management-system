package admin;

import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewAccountant {

    public static void viewAccountant() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from accountant");

            System.out.println("\nID  Name  Email  Contact");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("name") + " "
                                + rs.getString("email") + " "
                                + rs.getString("contact")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
