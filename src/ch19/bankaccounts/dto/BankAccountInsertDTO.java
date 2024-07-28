package gr.aueb.cf.ch19.bankaccounts.dto;

public class BankAccountInsertDTO extends BaseDTO {
    private String iban;
    private UserInsertDTO userInsertDTO;
    private double balance;

    public BankAccountInsertDTO() {

    }

    public BankAccountInsertDTO(long id, String iban, UserInsertDTO userInsertDTO, double balance) {
        this.setId(id);
        this.iban = iban;
        this.userInsertDTO = userInsertDTO;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserInsertDTO getUserInsertDTO() {
        return userInsertDTO;
    }

    public void setUserInsertDTO(UserInsertDTO userInsertDTO) {
        this.userInsertDTO = userInsertDTO;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
