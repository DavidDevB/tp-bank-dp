package models;

public class CurrentAccount extends Account {
    private Number overdraftLimit;

    public CurrentAccount(String ownerFirstName, String ownerLastName, String creationDate, Number balance, String accountNumber, Number overdraftLimit) {
        super(ownerFirstName, ownerLastName, creationDate, balance, accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    public Number getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Number overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}