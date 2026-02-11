package models;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String ownerFirstName, String ownerLastName, String creationDate, Number balance, String accountNumber, double interestRate) {
        super(ownerFirstName, ownerLastName, creationDate, balance, accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance().doubleValue() * (interestRate / 100);
        setBalance(getBalance().doubleValue() + interest);
    }
}