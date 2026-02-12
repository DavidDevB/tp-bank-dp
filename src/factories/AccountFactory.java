package factories;

import exceptions.InvalidAccountTypeException;
import models.Account;
import models.CurrentAccount;
import models.SavingsAccount;

public class AccountFactory {

  public static Account createAccount(
    String accountType,
    String ownerFirstName,
    String ownerLastName,
    String creationDate,
    Number balance,
    String accountNumber,
    double interestRate
  ) throws InvalidAccountTypeException {
    if (accountType.equalsIgnoreCase("savings")) {
      return new SavingsAccount(
        ownerFirstName,
        ownerLastName,
        creationDate,
        balance,
        accountNumber,
        interestRate
      );
    } else if (accountType.equalsIgnoreCase("current")) {
      return new CurrentAccount(
        ownerFirstName,
        ownerLastName,
        creationDate,
        balance,
        accountNumber,
        interestRate
      );
    } else {
      throw new InvalidAccountTypeException(
        "Invalid account type: " + accountType
      );
    }
  }
}
