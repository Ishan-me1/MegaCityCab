package dao;

import java.sql.*;
import model.User;
import model.DBConnection;

public class UserDAO {

    // Register a new user without password hashing
    public boolean registerUser(String username, String password, String email, String phone, String role) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet checkRs = null;
        PreparedStatement checkStmt = null;

        try {
            conn = DBConnection.getConnection();

            // Check if the username or email already exists
            String checkQuery = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
            checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            checkStmt.setString(2, email);
            checkRs = checkStmt.executeQuery();

            if (checkRs.next() && checkRs.getInt(1) > 0) {
                return false;
            }

            // Insert a new user with the role
            String sql = "INSERT INTO users (username, password, email, phone, role) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // Storing the plain-text password
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, role);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    // Validate user login and fetch role without password hashing
    public User validateUser(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();

            String query = "SELECT user_id, username, role FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password); // Compare with plain-text password

            rs = stmt.executeQuery();
            if (rs.next()) {
                // Return user with role
                return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("role"));
            } else {
                System.out.println("Invalid login credentials.");
            }
        } catch (SQLException e) {
            System.err.println("Login validation failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null; // Login failed
    }

    // Method to add customer information after registration
    public int addCustomer(String name, String address, String nic, String phone) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO customers (name, address, nic, phone) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, nic);
            stmt.setString(4, phone);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);  // Return generated customer ID
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1; // Return -1 if customer insertion failed
    }
}
