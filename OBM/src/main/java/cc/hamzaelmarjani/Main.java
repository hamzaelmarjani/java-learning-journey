package cc.hamzaelmarjani;

import cc.hamzaelmarjani.account.AccountAccess;
import cc.hamzaelmarjani.console.ConsoleLog;

public class Main {
    private static final ConsoleLog consoleLog = new ConsoleLog();
    private static final AccountAccess accountAccess = new AccountAccess();

    static void main() {
        System.out.println();
        System.out.println("****** Online Bank System ******");
        System.out.println();

        consoleLog.printAccountsCredentials();
        accountAccess.loginByAccountNumber();
    }
}
