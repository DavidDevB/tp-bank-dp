package models;

public class SavingsAccount extends Account {

  private double interestRate;

  public SavingsAccount(
    String ownerFirstName,
    String ownerLastName,
    String creationDate,
    double balance,
    String accountNumber,
    String state,
    int clientId,
    int id,
    double interestRate
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
    this.interestRate = interestRate;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  public void applyInterest() {
    double interest = getBalance() * (interestRate / 100);
    setBalance(getBalance() + interest);
  }
}
