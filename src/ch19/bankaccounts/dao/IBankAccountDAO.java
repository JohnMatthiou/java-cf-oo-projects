package gr.aueb.cf.ch19.bankaccounts.dao;

import gr.aueb.cf.ch19.bankaccounts.model.BankAccount;

import java.util.List;

public interface IBankAccountDAO {
BankAccount insert(BankAccount account);
BankAccount update(long id, BankAccount account);
void delete(long id);
void delete(String iban);
BankAccount get(long id);
BankAccount get(String iban);
List<BankAccount> getAll();
double deposit(String iban, double amount);
double withdraw(String iban, double amount);
double getBalance(long id);
double getBalance(String iban);
String getSsn(String iban);
boolean ibanExists(String iban);
boolean accountIdExists(long id);
}
