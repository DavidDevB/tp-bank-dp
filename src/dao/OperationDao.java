package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Operation;
import utils.DBConnection;

public class OperationDao {

  public static Operation addOperation(
    String type,
    double amount,
    int accountId,
    int operationNumber,
    Date operationDate
  ) throws SQLException {
    String query =
      "INSERT INTO operations (type, amount, account_id, operation_number, operation_date) VALUES (?, ?, ?, ?, ?)";
    try (
      Connection connection = DBConnection.getConnection();
      PreparedStatement stmt = connection.prepareStatement(query)
    ) {
      stmt.setString(1, type);
      stmt.setDouble(2, amount);
      stmt.setInt(3, accountId);
      stmt.setInt(4, operationNumber);
      stmt.setDate(5, operationDate);
      stmt.executeUpdate();
    }
    return new Operation(
      type,
      amount,
      accountId,
      operationNumber,
      operationDate
    );
  }

  public static ResultSet getOperationsByNumber(int operationNumber)
    throws SQLException {
    String query = "SELECT * FROM operations WHERE operation_number = ?";
    try (
      Connection connection = DBConnection.getConnection();
      PreparedStatement stmt = connection.prepareStatement(query)
    ) {
      stmt.setInt(1, operationNumber);
      return stmt.executeQuery();
    }
  }
}
