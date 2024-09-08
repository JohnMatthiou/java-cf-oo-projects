package ch19.bankaccounts.service.exceptions;

import ch19.bankaccounts.model.BankAccount;

public class IbanAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public IbanAlreadyExistsException(BankAccount account) {
        super("Bank account with iban: " + account.getIban() + " already exists");
    }
}
