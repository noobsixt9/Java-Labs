package Lab8.CRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost;database=JavaDB;integratedSecurity=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(url)) {
            String query = "update employee set empAge = ? where empID = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 20);
            ps.setInt(2, 6);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
