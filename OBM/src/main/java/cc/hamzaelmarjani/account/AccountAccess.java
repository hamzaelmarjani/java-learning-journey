package cc.hamzaelmarjani.account;

import cc.hamzaelmarjani.console.ConsoleLog;
import cc.hamzaelmarjani.console.ConsoleReadWithType;
import cc.hamzaelmarjani.database.BankDatabase;

public class AccountAccess {
    private static BankDatabase database;
    private final ConsoleLog consoleLog;
    private final ConsoleReadWithType consoleReadWithType;


    public AccountAccess() {
        database = new BankDatabase();
        consoleReadWithType = new ConsoleReadWithType();
        consoleLog = new ConsoleLog();
    }

    public void loginByAccountNumber() {
        var inputNumber = consoleReadWithType.readAccountNumber();
        var account = getAccountByNumber(inputNumber);

        if (account != null) {
            var inputPassword = consoleReadWithType.readAccountPassword();

            if (!inputPassword.equals(account.getPassword())) {
                System.out.println("Wrong password! please check again.");
                loginByAccountNumber();
            }

            consoleLog.userActions(account, true, true, false);
        } else {
            System.out.println("Account not found, please check again.");
            loginByAccountNumber();
        }
    }

    static Account getAccountByNumber(String accountNumber) {
        for (Account account : database) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
