package services;

import dao.AccountDao;
import exceptions.InvalidAccountTypeException;
import factories.AccountFactory;
import models.Account;

public class AccountService {

  public Account openAccount(
    String accountType,
    String ownerFirstName,
    String ownerLastName,
    String creationDate,
    Number balance,
    String accountNumber,
    double interestRate
  ) throws InvalidAccountTypeException {
    Account account = AccountFactory.createAccount(
      accountType,
      ownerFirstName,
      ownerLastName,
      creationDate,
      balance,
      accountNumber,
      interestRate
    );
    account.setState("active");
    account.setBalance(balance.doubleValue());

    AccountDao.create(account);

    return account;
  }
}
