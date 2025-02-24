package dao;

import java.sql.*;
import model.User; 
import model.DBConnection; 

public class UserDAO {

	public boolean registerUser(String username, String password, String email, String phone) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet checkRs = null;
	    PreparedStatement checkStmt = null;

	    try {
	        // Get the database connection
	        conn = DBConnection.getConnection();

	        // Check if the username or email already exists
	        String checkQuery = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
	        checkStmt = conn.prepareStatement(checkQuery);
	        checkStmt.setString(1, username);
	        checkStmt.setString(2, email);
	        checkRs = checkStmt.executeQuery();

	        if (checkRs.next() && checkRs.getInt(1) > 0) {
	            // Return false if the username or email already exists
	            System.out.println("Username or email already exists.");
	            return false;
	        }

	        // Prepare the SQL query to insert a new user
	        String sql = "INSERT INTO users (username, password, email, phone) VALUES (?, ?, ?, ?)";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, username);
	        stmt.setString(2, password);  // Storing the plain text password (should ideally be hashed)
	        stmt.setString(3, email);
	        stmt.setString(4, phone);

	        // Execute the query and check if rows are affected
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;

	    } catch (SQLException e) {
	        System.err.println("Error during registration: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    } finally {
	        // Close resources
	        DBConnection.closeConnection();
	    }
	}


    // Validate user login
    public User validateUser(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // Get a connection from the DBConnection class
            conn = DBConnection.getConnection();

            // Query to check if the username and password match
            String query = "SELECT user_id, username FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password); // Plain text password (consider hashing)

            rs = stmt.executeQuery();
            if (rs.next()) {
                // Return the user object if login is successful
                return new User(rs.getInt("user_id"), rs.getString("username"));
            } else {
                System.out.println("Invalid login credentials.");
            }
        } catch (SQLException e) {
            System.err.println("Login validation failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                // Clean up resources
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null; // Login failed
    }
}
