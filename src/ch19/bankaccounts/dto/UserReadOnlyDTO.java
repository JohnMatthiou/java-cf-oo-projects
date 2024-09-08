package ch19.bankaccounts.dto;

public class UserReadOnlyDTO extends BaseDTO {
    private String firstname;
    private String lastname;
    private String ssn;

    public UserReadOnlyDTO() {

    }

    public UserReadOnlyDTO(long id, String firstname, String lastname, String ssn) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
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
}
