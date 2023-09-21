package bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String username;
    private String password;
    private double balance;
    private List<Operation> operations;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.operations = new ArrayList<Operation>();
    }

    protected double getBalance() {
        return balance;
    }

    protected List<Operation> getOperations() {
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
