package gr.aueb.cf.ch19.bankaccounts.service.exceptions;

public class SsnNotValidException extends Exception {
    private final static long serialVersionUID = 1L;

    public SsnNotValidException() {
        super("Error. Invalid ssn.");
    }
}
