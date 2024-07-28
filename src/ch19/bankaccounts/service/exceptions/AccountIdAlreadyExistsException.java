package gr.aueb.cf.ch19.bankaccounts.service.exceptions;

import gr.aueb.cf.ch19.bankaccounts.model.BankAccount;

public class AccountIdAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public AccountIdAlreadyExistsException(BankAccount account) {
        super("Bank account with id: " + account.getId() + " already exists");
    }
}
