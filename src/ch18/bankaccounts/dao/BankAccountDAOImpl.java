package ch18.bankaccounts.dao;

import ch18.bankaccounts.model.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankAccountDAOImpl implements IBankAccountDAO {
    private final static List<BankAccount> accounts = new ArrayList<>();

    @Override
    public BankAccount insert(BankAccount account) {
        accounts.add(account);
        return account;
    }

    @Override
    public BankAccount update(long id, BankAccount account) {
        Optional<BankAccount> optionalAccount = accounts
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        BankAccount ba = optionalAccount.orElse(null);
        if (ba == null) return null;

        BankAccount accountToReturn = new BankAccount(ba);
        ba.setId(account.getId());
        ba.setIban(account.getIban());
        ba.setHolder(account.getHolder());
        ba.setBalance(account.getBalance());

        return accountToReturn;
    }

    @Override
    public void delete(long id) {
        accounts.removeIf(a -> a.getId() == id);
    }

    @Override
    public void delete(String iban) {
        accounts.removeIf(a -> a.getIban().equals(iban));
    }

    @Override
    public BankAccount get(long id) {
        return accounts.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public BankAccount get(String iban) {
        return accounts.stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BankAccount> getAl() {
        return new ArrayList<>(accounts);
    }

    @Override
    public double deposit(String iban, double amount) {
        BankAccount ba = accounts.stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst()
                .orElse(null);
        if (ba == null) return -1;

        ba.setBalance(ba.getBalance() + amount);
        return ba.getBalance();
    }

    @Override
    public double withdraw(String iban, double amount) {
        BankAccount ba = accounts.stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst()
                .orElse(null);
        if (ba == null) return -1;

        ba.setBalance(ba.getBalance() - amount);
        return ba.getBalance();
    }

    @Override
    public double getBalance(long id) {
        BankAccount ba = accounts.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
        if (ba == null) return -1;

        return ba.getBalance();
    }

    @Override
    public double getBalance(String iban) {
        BankAccount ba = accounts.stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst()
                .orElse(null);
        if (ba == null) return -1;

        return ba.getBalance();
    }

    @Override
    public String getSsn(String iban) {
        BankAccount ba = get(iban);
        if (ba == null) return null;
        if (ba.getHolder() == null) return null;
        return  ba.getHolder().getSsn();
    }

    @Override
    public boolean ibanExists(String iban) {
       return accounts.stream()
               .anyMatch(a -> a.getIban().equals(iban));
    }

    @Override
    public boolean accountIdExists(long id) {
        return accounts.stream()
                .anyMatch(a -> a.getId() == id);
    }
}
