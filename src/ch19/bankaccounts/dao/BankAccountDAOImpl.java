package ch19.bankaccounts.dao;

import ch19.bankaccounts.model.BankAccount;

import java.util.*;

public class BankAccountDAOImpl implements IBankAccountDAO {
    private final static Map<Long, BankAccount> accounts = new HashMap<>();

    @Override
    public BankAccount insert(BankAccount account) {
        accounts.put(account.getId() , account);
        return account;
    }

    @Override
    public BankAccount update(long id, BankAccount account) {
//        Optional<BankAccount> optionalAccount = accounts
//                .values().stream()
//                .filter(a -> a.getId() == id)
//                .findFirst();
//        BankAccount ba = optionalAccount.orElse(null);
//        if (ba == null) return null;
        BankAccount ba = accounts.get(account.getId());
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
        accounts.remove(id);
    }

    @Override
    public void delete(String iban) {
        Iterator<Map.Entry<Long, BankAccount>> it = accounts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, BankAccount> entry = it.next();
            if (entry.getValue().getIban().equals(iban)) {
                it.remove();
            }
        }
    }

    @Override
    public BankAccount get(long id) {
        return accounts.get(id);
    }

    @Override
    public BankAccount get(String iban) {
        return accounts.values().stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BankAccount> getAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public double deposit(String iban, double amount) {
        BankAccount ba = accounts.values().stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst()
                .orElse(null);
        if (ba == null) return -1;

        ba.setBalance(ba.getBalance() + amount);
        return ba.getBalance();
    }

    @Override
    public double withdraw(String iban, double amount) {
        BankAccount ba = accounts.values().stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst()
                .orElse(null);
        if (ba == null) return -1;

        ba.setBalance(ba.getBalance() - amount);
        return ba.getBalance();
    }

    @Override
    public double getBalance(long id) {
        BankAccount ba = accounts.get(id);
        if (ba == null) return -1;

        return ba.getBalance();
    }

    @Override
    public double getBalance(String iban) {
        BankAccount ba = accounts.values().stream()
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
       return accounts.values().stream()
               .anyMatch(a -> a.getIban().equals(iban));
    }

    @Override
    public boolean accountIdExists(long id) {
        return accounts.containsKey(id);
    }
}
