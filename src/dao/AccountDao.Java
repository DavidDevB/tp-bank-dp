package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import utils.DBConnection;

public class AccountDao {

  public static List<Account> readAll() {
    List<Account> accounts = new ArrayList<>();
    String query = "SELECT * FROM accounts";
    try (
      Connection connection = DBConnection.getConnection();
      PreparedStatement ps = connection.prepareStatement(query);
      ResultSet rs = ps.executeQuery()
    ) {
      while (rs.next()) {
        int id = rs.getInt("id");
        String accountNumber = rs.getString("accountNumber");
        double balance = rs.getDouble("balance");
        int clientId = rs.getInt("fk_client_id");
        Account account = new Account(id, accountNumber, balance, clientId);
        accounts.add(account);
      }
    } catch (SQLException e) {
      System.out.println("Error reading accounts: " + e.getMessage());
    }
    return accounts;
  }

  public static Account read(int id) {
    String query = "SELECT * FROM accounts WHERE id = ?";
    try (
      Connection connection = DBConnection.getConnection();
      PreparedStatement ps = connection.prepareStatement(query)
    ) {
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        String accountNumber = rs.getString("accountNumber");
        double balance = rs.getDouble("balance");
        int clientId = rs.getInt("fk_client_id");
        return new Account(id, accountNumber, balance, clientId);
      }
    } catch (SQLException e) {
      System.out.println("Error reading account: " + e.getMessage());
    }
    return null;
  }

  public static boolean create(Account account) {
    String query =
      "INSERT INTO accounts (accountNumber, balance, fk_client_id, creationDate, state) VALUES (?, ?, ?, ?, ?)";
    try (
      Connection connection = DBConnection.getConnection();
      PreparedStatement ps = connection.prepareStatement(query)
    ) {
      ps.setString(1, account.getAccountNumber());
      ps.setDouble(2, account.getBalance());
      ps.setInt(3, account.getClientId());
      ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
      ps.setString(5, "active");
      int rowsAffected = ps.executeUpdate();
      return rowsAffected > 0;
    } catch (SQLException e) {
      System.out.println("Error creating account: " + e.getMessage());
    }
    return false;
  }

  public static boolean update(Account account) {
    String query =
      "UPDATE accounts SET accountNumber = ?, balance = ?, fk_client_id = ?, creationDate = ?, state = ? WHERE id = ?";
    try (
      Connection connection = DBConnection.getConnection();
      PreparedStatement ps = connection.prepareStatement(query)
    ) {
      ps.setString(1, account.getAccountNumber());
      ps.setDouble(2, account.getBalance());
      ps.setInt(3, account.getClientId());
      ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
      ps.setString(5, "active");
      ps.setInt(6, account.getId());
      int rowsAffected = ps.executeUpdate();
      return rowsAffected > 0;
    } catch (SQLException e) {
      System.out.println("Error updating account: " + e.getMessage());
    }
    return false;
  }

  public static boolean delete(int id) {
    String query = "DELETE FROM accounts WHERE id = ?";
    try (
      Connection connection = DBConnection.getConnection();
      PreparedStatement ps = connection.prepareStatement(query)
    ) {
      ps.setInt(1, id);
      int rowsAffected = ps.executeUpdate();
      return rowsAffected > 0;
    } catch (SQLException e) {
      System.out.println("Error deleting account: " + e.getMessage());
    }
    return false;
  }
}
