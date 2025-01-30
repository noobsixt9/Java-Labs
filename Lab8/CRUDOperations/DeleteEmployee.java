package Lab8.CRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost;database=JavaDB;integratedSecurity=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(url)) {
            String query = "delete from employee where empID = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 2);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
