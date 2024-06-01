package bankapp.model;

/**
 * Represents a {@link JointAccount}, where two holders
 * can share the same bank account.
 */
public class JointAccount {
    private int id;
    private String iban;
    private String fnameHolder1;
    private String lnameHolder1;
    private String ssn1;
    private String fnameHolder2;
    private String lnameHolder2;
    private String ssn2;
    private double balance;

    public JointAccount() {

    }

    public JointAccount(int id, String iban, String fnameHolder1, String lnameHolder1, String ssn1, String fnameHolder2, String lnameHolder2, String ssn2, double balance) {
        this.id = id;
        this.iban = iban;
        this.fnameHolder1 = fnameHolder1;
        this.lnameHolder1 = lnameHolder1;
        this.ssn1 = ssn1;
        this.fnameHolder2 = fnameHolder2;
        this.lnameHolder2 = lnameHolder2;
        this.ssn2 = ssn2;
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

    public String getFnameHolder1() {
        return fnameHolder1;
    }

    public void setFnameHolder1(String fnameHolder1) {
        this.fnameHolder1 = fnameHolder1;
    }

    public String getLnameHolder1() {
        return lnameHolder1;
    }

    public void setLnameHolder1(String lnameHolder1) {
        this.lnameHolder1 = lnameHolder1;
    }

    public String getSsn1() {
        return ssn1;
    }

    public void setSsn1(String ssn1) {
        this.ssn1 = ssn1;
    }

    public String getFnameHolder2() {
        return fnameHolder2;
    }

    public void setFnameHolder2(String fnameHolder2) {
        this.fnameHolder2 = fnameHolder2;
    }

    public String getLnameHolder2() {
        return lnameHolder2;
    }

    public void setLnameHolder2(String lnameHolder2) {
        this.lnameHolder2 = lnameHolder2;
    }

    public String getSsn2() {
        return ssn2;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Public API

    /**
     * Deposits a certain amount of money  in a
     * {@link JointAccount}
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
     * Withdraws an amount of money from an {@link JointAccount}
     * based on a valid ssn.
     *
     * @param amount the amount of money to withdraw.
     * @param ssn    the given ssn.
     * @throws Exception if the balance is insufficient or if
     *                   the ssn is not valid.
     */

    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) {
                throw new Exception("Ssn is not valid exception");
            }

            if (amount > balance) {
                throw new Exception("Insufficient balance");
            }

            balance -= amount;
            System.out.println("Withdraw " + amount + " success.");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Returns the balance of the {@link JointAccount}.
     *
     * @return the {@link JointAccount}'s balance.
     */
    public double getAccountBalance() {
        System.out.println("Return of account balance success");
        return getBalance();
    }

    /**
     * Return the  {@link JointAccount} state in {@link String} format
     *
     * @return the String-representation of the state of the {@link JointAccount}
     */
    public String accountToString() {
        return "(" + id + ", " + iban + ", " + fnameHolder1 + ", " + lnameHolder1
                + ", " + ssn1 + ", " + fnameHolder2 + ", " + lnameHolder2
                + ", " + ssn2 + ", " + balance + ")";
    }

    private boolean isSsnValid(String ssn) {
        return (ssn1.equals(ssn) || ssn2.equals(ssn));
    }
}
