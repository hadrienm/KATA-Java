package bank;

public class Account {
    private String username;
    private String password;
    private double balance;
    private Operation[] operations;

    protected double getBalance() {
        return balance;
    }

    protected Operation[] getOperations() {
        return operations;
    }

    protected String getPassword() {
        return password;
    }

    protected String getUsername() {
        return username;
    }

    protected void addOperation() {

    }

}
