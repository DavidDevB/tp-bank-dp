package models;

import java.sql.Date;

public class Operation {

  private String type;
  private double amount;
  private Date operationDate;
  private int accountId;
  private int operationNumber;

  public Operation(
    String type,
    double amount,
    int accountId,
    int operationNumber,
    Date operationDate
  ) {
    this.type = type;
    this.amount = amount;
    this.operationDate = operationDate;
    this.accountId = accountId;
    this.operationNumber = operationNumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getOperationDate() {
    return operationDate;
  }

  public void setOperationDate(Date operationDate) {
    this.operationDate = operationDate;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public int getOperationNumber() {
    return operationNumber;
  }

  public void setOperationNumber(int operationNumber) {
    this.operationNumber = operationNumber;
  }
}
