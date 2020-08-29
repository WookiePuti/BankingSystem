package UI;

import backend.Account;

import java.util.Scanner;

public class LoggedMainUI implements ILoggedMainUI {
    private Account account;
    private Scanner scanner;

    public LoggedMainUI(Account account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    private void showMenu() {
        System.out.println("1. Balance\n" +
                "2. Log out\n" +
                "0. Exit");
    }

    public void start() {
        while (true) {
            showMenu();
            String command = scanner.nextLine();
            if (command.equals("1")) {
                System.out.println("Balance: " + account.getBalance());
            }
            else if (command.equals("2")) {
                break;
            }
            else if (command.equals("0")) {
                System.out.println("Bye");
                System.exit(1);
            }

        }
    }
}
