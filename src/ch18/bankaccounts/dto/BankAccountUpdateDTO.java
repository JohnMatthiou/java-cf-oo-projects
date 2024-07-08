package ch18.bankaccounts.dto;

public class BankAccountUpdateDTO extends BaseDTO {
    private String iban;
    private UserUpdateDTO userUpdateDTO;
    private double balance;

    public BankAccountUpdateDTO() {

    }

    public BankAccountUpdateDTO(long id, String iban, UserUpdateDTO userUpdateDTO, double balance) {
        this.setId(id);
        this.iban = iban;
        this.userUpdateDTO = userUpdateDTO;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserUpdateDTO getUserUpdateDTO() {
        return userUpdateDTO;
    }

    public void setUserUpdateDTO(UserUpdateDTO userUpdateDTO) {
        this.userUpdateDTO = userUpdateDTO;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
