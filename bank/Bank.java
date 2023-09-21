package bank;

import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Account> accounts;

    public String authentification() {

    }

    public void makeDeposit() {

    }

    public boolean makeWithdrawal() {

    }

    public List<Account> getOperationHistory() {

    }

    /**
     * check if the given username already exist in accounts database
     * 
     * @param username
     * @return true if the username already taken, otherwise false
     */
    private boolean checkUsernameAlreadyExist(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public void createAccount() {
        Scanner scan = new Scanner(System.in);
        String username;
        String password;

        System.out.print("Username: ");
        username = scan.nextLine();

        System.out.println("Password: ");
        password = scan.nextLine();

        while (checkUsernameAlreadyExist(username) != false) {
            System.out.println("Error: Username Already Exist");

            System.out.print("Username: ");
            username = scan.nextLine();

            System.out.println("Password: ");
            password = scan.nextLine();
        }

        Account account = new Account(username, password);

        this.accounts.add(account);

        System.out.println("Your acount has been created successfuly");

        scan.close();
    }

}
