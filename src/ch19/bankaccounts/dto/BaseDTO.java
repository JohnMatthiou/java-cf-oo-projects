package ch19.bankaccounts.dto;

public abstract class BaseDTO {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
