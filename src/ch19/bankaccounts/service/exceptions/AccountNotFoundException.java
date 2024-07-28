package gr.aueb.cf.ch19.bankaccounts.service.exceptions;

import gr.aueb.cf.ch19.bankaccounts.model.BankAccount;

public class AccountNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;

    public AccountNotFoundException(String iban) {
        super("Bank account with iban: " + iban + " not found");
    }

    public AccountNotFoundException(long id) {
        super("Bank account with id: " + id + " not found");
    }

    public AccountNotFoundException(BankAccount account) {
        super("Bank account with id: " + account.getId() +
                " and iban: " + account.getIban() + " not found");
    }
}
