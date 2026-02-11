package models;

public class Account {
    private String ownerFirstName;
    private String ownerLastName;
    private String creationDate;
    private Number balance;
    private String accountNumber;

    public Account(String ownerFirstName, String ownerLastName, String creationDate, Number balance, String accountNumber) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.creationDate = creationDate;
        this.balance = balance;
        this.accountNumber = accountNumber;
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

    public Number getBalance() {
        return balance;
    }

    public void setBalance(Number balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}