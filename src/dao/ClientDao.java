package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao {

  private Connection connection;

  public ClientDao(Connection connection) {
    this.connection = connection;
  }

  public boolean isClientExists(String email) throws SQLException {
    String query = "SELECT COUNT(*) FROM clients WHERE email = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, email);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return rs.getInt(1) > 0;
      }
    }
    return false;
  }

  public void addClient(String email, String name) throws SQLException {
    String query = "INSERT INTO clients (email, name) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, email);
      stmt.setString(2, name);
      stmt.executeUpdate();
    }
  }

  public String getClientName(String email) throws SQLException {
    String query = "SELECT name FROM clients WHERE email = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, email);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return rs.getString("name");
      }
    }
    return null;
  }

  public void updateClientName(String email, String newName)
    throws SQLException {
    String query = "UPDATE clients SET name = ? WHERE email = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, newName);
      stmt.setString(2, email);
      stmt.executeUpdate();
    }
  }

  public void deleteClient(String email) throws SQLException {
    String query = "DELETE FROM clients WHERE email = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, email);
      stmt.executeUpdate();
    }
  }
}
