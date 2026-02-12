package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationDao {

  public static void addOperation(
    Connection connection,
    String type,
    double amount,
    int accountId,
    int operationNumber,
    Date operationDate
  ) throws SQLException {
    String query =
      "INSERT INTO operations (type, amount, account_id, operation_number, operation_date) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, type);
      stmt.setDouble(2, amount);
      stmt.setInt(3, accountId);
      stmt.setInt(4, operationNumber);
      stmt.setDate(5, operationDate);
      stmt.executeUpdate();
    }
  }

  public static ResultSet getOperationsByNumber(
    Connection connection,
    int operationNumber
  ) throws SQLException {
    String query = "SELECT * FROM operations WHERE operation_number = ?";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setInt(1, operationNumber);
    return stmt.executeQuery();
  }
}
