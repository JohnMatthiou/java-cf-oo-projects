package gr.aueb.cf.ch19.bankaccounts.service.exceptions;

public class NegativeAmountException extends Exception {
    private final static long serialVersionUID = 1l;

    public NegativeAmountException() {
        super("You can not give a negative amount. Please try again.");
    }
}
