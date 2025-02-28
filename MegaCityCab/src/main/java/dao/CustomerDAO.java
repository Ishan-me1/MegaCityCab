package dao;

import java.sql.*;

import model.DBConnection;

public class CustomerDAO {
    public boolean registerCustomer(int userId, String name, String address, String nic, String phone) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO customers (user_id, name, address, nic, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.setString(4, nic);
            stmt.setString(5, phone);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getCustomerId(int userId) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT customer_id FROM customers WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("customer_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

