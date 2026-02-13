package services;

import dao.AccountDao;
import exceptions.InvalidAccountTypeException;
import factories.AccountFactory;
import models.Account;

public class AccountService {

  public Account openAccount(
    String ownerFirstName,
    String ownerLastName,
    String creationDate,
    double balance,
    String accountNumber,
    String state,
    int clientId,
    int id,
    String accountType,
    double interestRate,
    int overdraftLimit
  ) throws InvalidAccountTypeException {
    Account account = AccountFactory.createAccount(
      ownerFirstName,
      ownerLastName,
      creationDate,
      balance,
      accountNumber,
      state,
      clientId,
      id,
      accountType,
      interestRate,
      overdraftLimit
    );
    account.setState("active");
    account.setBalance(balance);

    AccountDao.create(account);

    return account;
  }

  public void freezeAccount(int accountId) {
    Account account = AccountDao.read(accountId);
    if (account != null) {
      account.setState("frozen");
      AccountDao.update(account);
    }
  }

  public void closeAccount(int accountId) {
    Account account = AccountDao.read(accountId);
    if (account != null) {
      account.setState("closed");
      AccountDao.update(account);
    }
  }

  public void unfreezeAccount(int accountId) {
    Account account = AccountDao.read(accountId);
    if (account != null) {
      account.setState("active");
      AccountDao.update(account);
    }
  }

  public void deposit(int accountId, double amount) {
    Account account = AccountDao.read(accountId);
    if (account != null && account.getState().equals("active")) {
      account.setBalance(account.getBalance() + amount);
      AccountDao.update(account);
    }
  }

  public void withdraw(int accountId, double amount) {
    Account account = AccountDao.read(accountId);
    if (account != null && account.getState().equals("active")) {
      account.setBalance(account.getBalance() - amount);
      AccountDao.update(account);
    }
  }
}
