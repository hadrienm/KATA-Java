import java.util.Scanner;

import bank.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);
        String answer;
        String token;

        System.out.println("Do you want create account or access to your account ? (create, access)");
        answer = scan.nextLine();

        while (!answer.toLowerCase().equals("create") && !answer.toLowerCase().equals("access")) {
            System.out.println("Error, please choice between create or access");
            answer = scan.nextLine();
        }

        if (answer.toLowerCase().equals("create")) {
            bank.createAccount();
        }

        if (answer.equals("access")) {
            token = bank.authenticate();

            while (token == null) {
                System.out.println("Account not found or password is incorrect, please try again");
                token = bank.authenticate();
            }

            System.out.println(
                    "Do you want make deposit, withdrawal or view operation history ? (deposit, withdraw, history)");
            answer = scan.nextLine();

            while (!answer.toLowerCase().equals("deposit") && !answer.toLowerCase().equals("withdraw")
                    && !answer.toLowerCase().equals("history")) {
                System.out.println("Error, please choice between deposit withdraw, or history");
                answer = scan.nextLine();
            }

            if (answer.toLowerCase().equals("deposit")) {
                bank.makeDeposit(token);
            } else if (answer.toLowerCase().equals("withdraw")) {
                bank.makeWithdrawal(token);
            } else {
                bank.getOperationHistory(token);
            }

            scan.close();
            return;
        }

        scan.close();
    }
}
