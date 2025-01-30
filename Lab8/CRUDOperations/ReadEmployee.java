package Lab8.CRUDOperations;

import java.sql.*;

public class ReadEmployee {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost;database=JavaDB;integratedSecurity=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(url)) {
            String query = "select empName from employee where empID = 1";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString("empName");
            System.out.println("Name: " + name);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
