package katajava.src.main.java.com.katajava;
import java.util.Scanner;

import katajava.src.main.java.com.katajava.bank.Bank;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Bank bank = new Bank();
    private static String token;

    /**
     * Ask to the user account information
     * 
     */
    private static void askCreateAccount() {
        String username;
        String password;

        System.out.print("Username: ");
        username = scan.nextLine();

        System.out.print("Password: ");
        password = scan.nextLine();

        if (bank.createAccount(username, password)) {
            System.out.println("Your acount has been created successfuly");
        } else {
            System.out.println("Username is already taken");
        }
    }

     /**
     * Ask to the user authentication information
     * 
     */
    private static void askAuthentication() {
        String username;
        String password;

        System.out.print("Username: ");
        username = scan.nextLine();

        System.out.print("Password: ");
        password = scan.nextLine();

        token = bank.authenticate(username, password);
    }

    /**
     * Ask to the user deposit information
     * 
     */
    private static void askDeposit() {
        double amount = 0;

        System.out.println("How much money do you want deposit ?");
        amount = scan.nextDouble();

        if (bank.makeDeposit(token, amount)) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        scan.nextLine();
    }

    /**
     * Ask to the user withdraw information
     * 
     */
    private static void askWithdraw() {
        double amount = 0;

        System.out.println("How much money do you want to withdraw ?");
        amount = scan.nextDouble();

        if (bank.makeWithdrawal(token, amount)) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        scan.nextLine();
    }

    public static void main(String[] args) {
        String answer;
        String answer2;

        while (true) {
            System.out.println("Do you want create account or access to your account ? (create, access, quit)");
            answer = scan.nextLine();

            while (!answer.toLowerCase().equals("create") && !answer.toLowerCase().equals("access")
                    && !answer.toLowerCase().equals("quit")) {
                System.out.println("Error, please choice between create or access");
                answer = scan.nextLine();
            }

            if (answer.toLowerCase().equals("create")) {
                askCreateAccount();
            } else if (answer.equals("access")) {
                askAuthentication();

                if (token == null) {
                    System.out.println("Account not found or password is incorrect, please try again");
                } else {
                    while (true) {
                        System.out.println(
                                "Do you want make deposit, withdrawal or view operation history ? (deposit, withdraw, history, quit)");
                        answer2 = scan.nextLine();

                        while (!answer2.toLowerCase().equals("deposit") && !answer2.toLowerCase().equals("withdraw")
                                && !answer2.toLowerCase().equals("history") && !answer2.toLowerCase().equals("quit")) {
                            System.out.println("Error, please choice between deposit withdraw, or history");
                            answer2 = scan.nextLine();
                        }

                        if (answer2.toLowerCase().equals("deposit")) {
                            askDeposit();
                        } else if (answer2.toLowerCase().equals("withdraw")) {
                            askWithdraw();
                        } else if (answer2.toLowerCase().equals("history")) {
                            bank.getOperationHistory(token);
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }

            answer = "";
            answer2 = "";
        }
        scan.close();
    }
}
