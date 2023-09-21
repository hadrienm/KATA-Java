package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
    private String token;
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

    protected String getToken() {
        return token;
    }

    protected void addOperation(Operation operation) {
        operations.add(operation);
    }

    protected String createToken() {
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

        StringBuilder s = new StringBuilder(20);

        for (int i = 0; i < 20; i++) {
            int ch = (int) (AlphaNumericStr.length() * Math.random());

            s.append(AlphaNumericStr.charAt(ch));
        }

        token = s.toString();

        return token;
    }
}
