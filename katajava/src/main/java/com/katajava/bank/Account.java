package katajava.src.main.java.com.katajava.bank;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Update account balance
     * 
     * @param amount Amount to add to the balance of the account
     */
    protected void updateBalance(double amount) {
        balance += amount;
    }

    /**
     * Add Operation to client account
     * 
     * @param operation Operation will be add on the account
     */
    protected void addOperation(Operation operation) {
        operations.add(operation);
    }

    /**
     * Create token for authenticate client
     * 
     * @return token, will be used for all client request to the bank function
     */
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
