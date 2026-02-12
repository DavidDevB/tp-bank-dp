package factories;

import exceptions.InvalidAccountTypeException;
import models.Account;
import models.CurrentAccount;
import models.SavingsAccount;

public class AccountFactory {

  public static Account createAccount(
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
    if (accountType.equalsIgnoreCase("savings")) {
      return new SavingsAccount(
        ownerFirstName,
        ownerLastName,
        creationDate,
        balance,
        accountNumber,
        state,
        clientId,
        id,
        interestRate
      );
    } else if (accountType.equalsIgnoreCase("current")) {
      return new CurrentAccount(
        ownerFirstName,
        ownerLastName,
        creationDate,
        balance,
        accountNumber,
        state,
        clientId,
        id,
        overdraftLimit
      );
    } else {
      throw new InvalidAccountTypeException(
        "Invalid account type: " + accountType
      );
    }
  }
}
