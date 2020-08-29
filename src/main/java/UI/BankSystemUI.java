package UI;

import backend.Account;
import backend.BankService;

import java.util.Optional;
import java.util.Scanner;

public class BankSystemUI {
    private final BankService bankService;


    public BankSystemUI() {
        bankService = new BankService();
    }

    void printMenu() {
        System.out.println("1. Create an account\n" +
                "2. Log into account\n" +
                "0. Exit");
    }

    public void start(){
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("1")) {
                bankService.createAccount();
                printMenu();
            }
            else if (command.equals("2")) {
                System.out.println("Enter your card number:");
                String cardNum = scanner.nextLine();
                System.out.println("Enter your PIN:");
                String password = scanner.nextLine();
                Optional<Account> account = bankService.login(cardNum, password);
                if (account.isPresent()) {
                    ILoggedMainUI loggedUI = new LoggedMainUI(account.get(), scanner);
                    loggedUI.start();
                }
                printMenu();
            }
            else if (command.equals("0")) {
                break;
            }
        }
    }
}
