package Lab8.CRUDOperations;

import java.sql.*;

public class CreateEmployee {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost;database=JavaDB;" +
                "integratedSecurity=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(url)) {
            String query = "insert into employee (empName, empAge, empAddress, empPosition)" +
                    "values (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "Ram");
            ps.setInt(2, 30);
            ps.setString(3, "Kathmandu");
            ps.setString(4, "Manager");

            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
