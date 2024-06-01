package bankapp.model;

import java.util.Scanner;

/**
 * Represents a {@link OverdraftAccount} of a bank customer
 * that lets the customer perform an overdraft on their account if the balance
 * is not sufficient during a withdrawal.
 */
public class OverdraftAccount {
    private int id;
    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;
    private double balance;

    public OverdraftAccount() {

    }

    public OverdraftAccount(int id, String iban, String firstname, String lastname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     * Deposits a certain amount of money  in a
     * {@link OverdraftAccount}
     *
     * @param amount the amount of money to be deposited.
     * @throws Exception if the amount is negative.
     */
    public void deposit(double amount) throws Exception {
        try {
            if (amount < 0) {
                throw new Exception("Negative amount Exception");
            }
            balance += amount;
            System.out.println("Deposit of " + amount + " success");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * Withdraws an amount of money from an {@link OverdraftAccount}
     * based on a valid ssn. If balance is not sufficient for the withdrawal, it asks
     * the user's permission to perform an overdraft on their account.
     *
     * @param amount the amount of money to withdraw.
     * @param ssn    the given ssn.
     * @throws Exception if the ssn is not valid.
     */

    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) {
                throw new Exception("Ssn is not valid exception");
            }

            if (amount > balance) {
                System.out.printf("Insufficient balance, an overdraft of %.2f must be performed\nContinue? Y/N (Press y for YES, n for NO)\n ", (balance >= 0) ? amount - balance : amount);
                if (isOverdraftAllowed()) {
                    balance -= amount;
                    System.out.println("Withdraw " + amount + " success.");
                } else {
                    System.out.println("Withdrawal aborted.");
                }
            } else {
                balance -= amount;
                System.out.println("Withdraw " + amount + " success.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Returns the balance of the {@link OverdraftAccount}.
     *
     * @return the {@link OverdraftAccount}'s balance.
     */
    public double getAccountBalance() {
        System.out.println("Return of account balance success");
        return getBalance();
    }

    /**
     * Return the  {@link OverdraftAccount} state in {@link OverdraftAccount} format
     *
     * @return the String-representation of the state of the {@link OverdraftAccount}
     */
    public String accountToString() {
        return "(" + id + ", " + iban + ", " + firstname + ", " + lastname
                + ", " + ssn + ", " + balance + ")";
    }

    private boolean isSsnValid(String ssn) {
        return this.ssn.equals(ssn);
    }

    /**
     * Gets the user's answer on whether to perform an overdraft on their
     * {@link OverdraftAccount} or not.
     *
     * @return  true if user inputted y (for YES), false if user inputted n (for NO)
     */
    private boolean isOverdraftAllowed() {
        Scanner in = new Scanner(System.in);
        String userAnswer;

        while (true) {
            userAnswer = in.nextLine();
            if (userAnswer.length() > 1) {
                System.out.println("Invalid input");
                System.out.println("Press y for YES, n for NO");
                continue;
            }
            if (userAnswer.equals("y") || userAnswer.equals("Y")) {
                return true;
            } else if (userAnswer.equals("n") || userAnswer.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input");
                System.out.println("Press y for YES, n for NO");
                continue;
            }

        }
    }

}
