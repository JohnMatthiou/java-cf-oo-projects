package gr.aueb.cf.ch19.bankaccounts.service.exceptions;

public class BalanceNotZeroException extends Exception {
    private final static long serialVersionUID = 1L;

    public BalanceNotZeroException(long id, double balance) {
        super("Cannot delete account with id: " + id +
                " cause balance is not zero. Remaining balance: " + balance + "€");
    }

    public BalanceNotZeroException(String iban, double balance) {
        super("Cannot delete account with iban: " + iban +
                " cause balance is not zero. Remaining balance: " + balance + "€");
    }
}
