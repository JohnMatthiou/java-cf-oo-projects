package ch18.bankaccounts.dto;

public class BankAccountReadOnlyDTO extends BaseDTO {
    private String iban;
    private UserReadOnlyDTO userReadOnlyDTO;
    private double balance;

    public BankAccountReadOnlyDTO() {

    }

    public BankAccountReadOnlyDTO(long id, String iban, UserReadOnlyDTO userReadOnlyDTO, double balance) {
        this.setId(id);
        this.iban = iban;
        this.userReadOnlyDTO = userReadOnlyDTO;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserReadOnlyDTO getUserReadOnlyDTO() {
        return userReadOnlyDTO;
    }

    public void setUserReadOnlyDTO(UserReadOnlyDTO userReadOnlyDTO) {
        this.userReadOnlyDTO = userReadOnlyDTO;
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
                ", Firstname: " + userReadOnlyDTO.getFirstname() +
                ", Lastname: " + userReadOnlyDTO.getLastname() +
                ", Ssn: " + userReadOnlyDTO.getSsn() +
                ", balance: " + balance + "€";
    }
}
