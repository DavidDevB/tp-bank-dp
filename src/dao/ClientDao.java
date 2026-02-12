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

  public void addClient(
    String firstName,
    String lastName,
    String birthDate,
    String email,
    String address
  ) throws SQLException {
    String query =
      "INSERT INTO clients (firstName, lastName, birthDate, email, address) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, firstName);
      stmt.setString(2, lastName);
      stmt.setString(3, birthDate);
      stmt.setString(4, email);
      stmt.setString(5, address);
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

  public void updateClient(
    String email,
    String newFirstName,
    String newLastName,
    String newBirthDate,
    String newAddress
  ) throws SQLException {
    String query =
      "UPDATE clients SET firstName = ?, lastName = ?, birthDate = ?, address = ? WHERE email = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, newFirstName);
      stmt.setString(2, newLastName);
      stmt.setString(3, newBirthDate);
      stmt.setString(4, newAddress);
      stmt.setString(5, email);
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
