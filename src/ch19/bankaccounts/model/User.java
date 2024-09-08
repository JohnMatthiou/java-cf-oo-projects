package ch19.bankaccounts.model;

import java.util.Objects;

public class User extends AbstractEntity implements IdentifiableEntity {
    private String firstname;
    private String lastname;
    private String ssn;

    public User() {

    }

    public User(long id, String firstname, String lastname, String ssn) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    public User(User user) {
        this.setId(user.getId());
        this.firstname = user.firstname;
        this.lastname = user.lastname;
        this.ssn = user.ssn;
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

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getFirstname(), user.getFirstname()) && Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getSsn(), user.getSsn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getSsn());
    }
}
