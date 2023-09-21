package bank;

import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Account> accounts;

    private Account getAccountByToken(String token) {
        for (Account account : accounts) {
            if (account.getToken() != null && account.getToken().equals(token)) {
                return account;
            }
        }

        return null;
    }

    public String authenticate(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                if (account.getPassword().equals(password)) {
                    return account.createToken();
                }
            }
        }

        return null;
    }

    public boolean makeDeposit(String token) {
        Scanner scanner = new Scanner(System.in);
        double ammount = 0;

        System.out.println("How much money do you want deposit ?");
        ammount = scanner.nextDouble();

        if (ammount < 0) {
            System.out.println("Error");
            scanner.close();
            return false;
        }

        Operation operation = new Operation(OperationType.DEPOSIT, ammount);

        Account account = getAccountByToken(token);

        account.addOperation(operation);

        System.out.println("Success");

        scanner.close();

        return true;
    }

    public boolean makeWithdrawal(String token) {
        Scanner scanner = new Scanner(System.in);
        double ammount = 0;

        System.out.println("How much money do you want to withdraw ?");
        ammount = scanner.nextDouble();

        if (ammount < 0) {
            System.out.println("Error");
            scanner.close();
            return false;
        }

        Operation operation = new Operation(OperationType.WITHDRAWAL, ammount);

        Account account = getAccountByToken(token);

        account.addOperation(operation);

        System.out.println("Success");

        scanner.close();

        return true;
    }

    public void getOperationHistory(String token) {
        Account account = getAccountByToken(token);

        System.out.println("Operation History : ");

        for (Operation operation : account.getOperations()) {
            System.out.print("\t" + operation.getDate());

            if (operation.getType() == OperationType.DEPOSIT) {
                System.out.print("\tDEPOSIT");
            } else {
                System.out.print("\tWITHDRAWAL");
            }

            System.out.println("\t" + operation.getAmount());
        }
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

        accounts.add(account);

        System.out.println("Your acount has been created successfuly");

        scan.close();
    }

}
