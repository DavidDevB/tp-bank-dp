package interfaces;

import models.Account;

public interface AccountState {
  void deposit(Account account, double amount);
  void withdraw(Account account, double amount);
  void checkBalance(Account account);
  void freezeAccount(Account account);
  void unfreezeAccount(Account account);
  void closeAccount(Account account);
}
