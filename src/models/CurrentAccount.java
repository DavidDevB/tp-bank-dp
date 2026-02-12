package models;

public class CurrentAccount extends Account {

  private Number overdraftLimit;

  public CurrentAccount(
    String ownerFirstName,
    String ownerLastName,
    String creationDate,
    double balance,
    String accountNumber,
    String state,
    int clientId,
    int id,
    Number overdraftLimit
  ) {
    super(
      ownerFirstName,
      ownerLastName,
      creationDate,
      balance,
      accountNumber,
      state,
      clientId,
      id
    );
    this.overdraftLimit = overdraftLimit;
  }

  public Number getOverdraftLimit() {
    return overdraftLimit;
  }

  public void setOverdraftLimit(Number overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }
}
