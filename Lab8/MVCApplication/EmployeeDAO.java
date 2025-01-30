package Lab8.MVCApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    private static final String url = "jdbc:sqlserver://localhost;database=JavaDB;integratedSecurity=true;trustServerCertificate=true";

    public boolean addEmployee(EmployeeModel model) {
        try (Connection con = DriverManager.getConnection(url)) {
            String query = "insert into employee (empName, empAge, empAddress, empPosition)" +
                    "values (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, model.getName());
            ps.setString(2, model.getAge());
            ps.setString(3, model.getAddress());
            ps.setString(4, model.getPosition());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}