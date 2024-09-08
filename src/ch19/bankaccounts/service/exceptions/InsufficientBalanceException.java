package ch19.bankaccounts.service.exceptions;

public class InsufficientBalanceException extends Exception {
    private final static long serialVersionUID = 1L;

    public InsufficientBalanceException(double balance) {
        super("Insufficient balance. Current account balance: " + balance + "€");
    }
}
