package models;

public class Account {

  private String ownerFirstName;
  private String ownerLastName;
  private String creationDate;
  private double balance;
  private String accountNumber;
  private String state;
  private final int id;
  private int clientId;

  public Account(
    String ownerFirstName,
    String ownerLastName,
    String creationDate,
    double balance,
    String accountNumber,
    String state,
    int clientId,
    int id
  ) {
    this.ownerFirstName = ownerFirstName;
    this.ownerLastName = ownerLastName;
    this.creationDate = creationDate;
    this.balance = balance;
    this.accountNumber = accountNumber;
    this.state = state;
    this.clientId = clientId;
    this.id = id;
  }

  public String getOwnerFirstName() {
    return ownerFirstName;
  }

  public void setOwnerFirstName(String ownerFirstName) {
    this.ownerFirstName = ownerFirstName;
  }

  public String getOwnerLastName() {
    return ownerLastName;
  }

  public void setOwnerLastName(String ownerLastName) {
    this.ownerLastName = ownerLastName;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getId() {
    return id;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }
}
