package cc.hamzaelmarjani.console;

import cc.hamzaelmarjani.account.Account;
import cc.hamzaelmarjani.database.BankDatabase;
import cc.hamzaelmarjani.utils.ConsoleUtils;
import cc.hamzaelmarjani.utils.DateUtils;
import cc.hamzaelmarjani.utils.ThreadUtils;

import java.text.NumberFormat;

public class ConsoleLog {
    private final BankDatabase database;
    private final DateUtils dateUtils;
    private final ConsoleReadWithType consoleReadWithType;
    private final NumberFormat currency;

    public ConsoleLog() {
        database = new BankDatabase();
        dateUtils = new DateUtils();
        consoleReadWithType = new ConsoleReadWithType();
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printFooter() {
        System.out.println();
        System.out.println("H: Help • Q: Quite • L: Log-out • B: Balance • A: Add Balance • T: Transfer Money • D: Account Created Date • R: Remove Account");
    }

    public void printAccountsCredentials() {
        var accounts = database.accounts;

        System.out.println("\uD83D\uDD12 For test propose, use one of the following account credentials to login:");
        System.out.println();

        System.out.println("---------------------------------");
        for (var i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + (i + 1) + ":");
            System.out.println("  • Login: " + accounts.get(i).getAccountNumber());
            System.out.println("  • Password: " + accounts.get(i).getPassword());
            System.out.println("---------------------------------");
            if (i + 1 >= accounts.size()) {
                System.out.println();
            }
        }
    }

    public void userActions(Account account, boolean clear, boolean showMenu, boolean ignoreGreeting) {
        if (clear) {
            ConsoleUtils.clear();
            System.out.println();
        }

        if (!ignoreGreeting) {
            System.out.println("\uD83D\uDC4B Welcome back " + account.getHolderName());
            System.out.println("\uD83D\uDCBC What do you want to do today?");
        }

        if (showMenu) {
            printFooter();
            System.out.println();
        }

        var action = consoleReadWithType.readUserAction();

        switch (action) {
            case "H":
                userActions(account, false, true, true);
                break;
            case "Q":
                System.out.println("\uD83D\uDC4B Thanks for your visit, see you!");
                ThreadUtils.sleep(500);
                System.exit(0);
                break;
            case "B":
                displayAccountBalance(account.getBalance(), false);
                userActions(account, false, false, true);
                break;
            case "L":
                var logoutConfirm = consoleReadWithType.logoutConfirm();
                if (logoutConfirm.equals("yes") || logoutConfirm.equals("y")) {
                    System.exit(0);
                }
                userActions(account, false, false, true);
                break;
            case "A":
                var balance = consoleReadWithType.addBalance();
                account.setBalance(account.getBalance() + balance);
                System.out.println("✅ " + currency.format(balance) + " added to your balance.");
                displayAccountBalance(account.getBalance(), true);
                userActions(account, false, false, true);
                break;
            case "T":
                var amount = consoleReadWithType.transferMoneyBalance();
                if (account.getBalance() < amount) {
                    System.out.println("❌ You don't have enough balance on your account.");
                    System.out.println("Transfer amount: " + currency.format(amount) + ", Your balance: " + currency.format(account.getBalance()));
                } else {
                    var receivingAccountNumber = consoleReadWithType.transferMoneyAccount();
                    if (receivingAccountNumber.isEmpty()) {
                        System.out.println("❌ Please enter a valid receiving account number!");
                    } else {
                        account.setBalance(account.getBalance() - amount);
                        System.out.println("✅ " + currency.format(amount) + " transferred to the receiving account number " + receivingAccountNumber);
                        displayAccountBalance(account.getBalance(), true);
                    }
                }
                userActions(account, false, false, true);
                break;
            case "D":
                System.out.println("\uD83D\uDCC5 Account created on " + dateUtils.humanReadableDate(account.getCreatedAt()));
                userActions(account, false, false, true);
                break;
            case "R":
                var removeConfirm = consoleReadWithType.removeAccountConfirm();
                if (removeConfirm.equals("yes") || removeConfirm.equals("y")) {
                    System.out.println("\uD83D\uDDD1️ Account under number " + account.getAccountNumber() + " removed successfully.");
                    ThreadUtils.sleep(500);
                    System.exit(0);
                }
                userActions(account, false, false, true);
                break;
            default:
                System.out.println("\uD83D\uDD34 Invalid action chose, please try again");
                System.out.println();
                userActions(account, false, true, true);
                break;
        }
    }

    void displayAccountBalance(double balance, boolean refreshed) {
        System.out.println("\uD83D\uDCB0 Your" + (refreshed ? " new " : " ") + "balance until " + dateUtils.humanReadableDate() + " : " + currency.format(balance));
    }
}
