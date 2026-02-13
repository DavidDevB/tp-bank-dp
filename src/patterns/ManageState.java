package patterns;

import interfaces.AccountState;
import models.Account;
import services.AccountService;

public class ManageState implements AccountState {

  @Override
  public void unfreezeAccount(Account account) {
    // Implementation for unfreezing an active account (not applicable for active state)
    AccountService accountService = new AccountService();
    accountService.unfreezeAccount(account.getId());
  }

  @Override
  public void deposit(Account account, double amount) {
    // Implementation for depositing money into an active account
    AccountService accountService = new AccountService();
    accountService.deposit(account.getId(), amount);
  }

  @Override
  public void withdraw(Account account, double amount) {
    // Implementation for withdrawing money from an active account
    AccountService accountService = new AccountService();
    accountService.withdraw(account.getId(), amount);
  }

  @Override
  public void checkBalance(Account account) {
    // Implementation for checking balance of an active account
    System.out.println("Current balance: " + account.getBalance());
  }

  @Override
  public void freezeAccount(Account account) {
    // Implementation for freezing an active account
    AccountService accountService = new AccountService();
    accountService.freezeAccount(account.getId());
  }

  @Override
  public void closeAccount(Account account) {
    // Implementation for closing an active account
    AccountService accountService = new AccountService();
    accountService.closeAccount(account.getId());
  }
}
