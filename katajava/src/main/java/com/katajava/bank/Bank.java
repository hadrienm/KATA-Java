package katajava.src.main.java.com.katajava.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<Account>();

    /**
     * Get account by user token
     * 
     * @param token user token
     * @return account of the user linked to the token
     */
    private Account getAccountByToken(String token) {
        for (Account account : accounts) {
            if (account.getToken() != null && account.getToken().equals(token)) {
                return account;
            }
        }

        return null;
    }

    /**
     * Check if the given login information is correct
     * 
     * @param username
     * @param password
     * 
     * @return token if the information is correct, otherwise null
     */
    public String authenticate(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account.createToken();
            }
        }

        return null;
    }

    /**
     * Function in charge of create deposit
     * 
     * @param token  token of the client
     * @param amount amount of money to deposit of the account
     * 
     * @return true if success otherwise false
     */
    public boolean makeDeposit(String token, double amount) {
        if (amount < 0) {
            return false;
        }

        Operation operation = new Operation(OperationType.DEPOSIT, amount);

        Account account = getAccountByToken(token);

        account.addOperation(operation);
        account.updateBalance(amount);

        return true;
    }

    /**
     * Function in charge of create withdrawal
     * 
     * @param token  token of the client
     * @param amount amount of money to deposit of the account
     * @return true if success otherwise false
     * 
     */
    public boolean makeWithdrawal(String token, double amount) {
        if (amount < 0) {
            return false;
        }

        Operation operation = new Operation(OperationType.WITHDRAWAL, amount);

        Account account = getAccountByToken(token);

        account.addOperation(operation);
        account.updateBalance(amount * -1);

        return true;
    }

    /**
     * Get user operatio history
     * 
     * @param token token of the client
     */
    public void getOperationHistory(String token) {
        Account account = getAccountByToken(token);

        System.out.println("Operation History : ");

        if (account.getOperations().isEmpty()) {
            System.out.println("No operation found");
            return;
        }

        for (Operation operation : account.getOperations()) {
            System.out.print("\t" + operation.getDate());

            if (operation.getType() == OperationType.DEPOSIT) {
                System.out.print("\tDEPOSIT");
            } else {
                System.out.print("\tWITHDRAWAL");
            }

            System.out.println("\t" + operation.getAmount());
        }

        System.out.println();
        System.out.println("Your balence : " + account.getBalance());
    }

    /**
     * check if the given username already exist in accounts database
     * 
     * @param username
     * @return true if the username already taken, otherwise false
     */
    private boolean checkUsernameAlreadyExist(String username) {
        if (accounts == null) {
            return false;
        }

        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Create bank account fo a user
     * 
     * @param username
     * @param password
     * @return
     */
    public boolean createAccount(String username, String password) {
        if (checkUsernameAlreadyExist(username) == true) {
            return false;
        }

        Account account = new Account(username, password);

        accounts.add(account);

        return true;
    }

}
