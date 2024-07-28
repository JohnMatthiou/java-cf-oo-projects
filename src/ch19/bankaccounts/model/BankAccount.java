package gr.aueb.cf.ch19.bankaccounts.model;

import java.util.Objects;

public class BankAccount extends AbstractEntity implements IdentifiableEntity {
    private String iban;
    private User holder;
    private double balance;

    public BankAccount() {

    }

    public BankAccount(long id, String iban, User holder, double balance) {
        this.setId(id);
        this.iban = iban;
        this.holder = new User(holder);
        this.balance = balance;
    }

    public BankAccount(BankAccount bankAccount) {
        this.setId(bankAccount.getId());
        this.iban = bankAccount.iban;
        this.holder = new User(bankAccount.getHolder());
        this.balance = bankAccount.getBalance();
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getHolder() {
        return new User(holder);
    }

    public void setHolder(User holder) {
        this.holder = new User(holder);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "IBAN: " + iban +
                ", Firstname: " + holder.getFirstname() +
                ", Lastname: " + holder.getLastname() +
                ", Ssn: " + holder.getSsn() +
                ", balance: " + balance + "€";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(getBalance(), that.getBalance()) == 0 && Objects.equals(getIban(), that.getIban()) && Objects.equals(getHolder(), that.getHolder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIban(), getHolder(), getBalance());
    }
}
