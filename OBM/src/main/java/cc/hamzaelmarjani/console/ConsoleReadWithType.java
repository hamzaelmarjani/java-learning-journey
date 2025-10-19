package cc.hamzaelmarjani.console;

public class ConsoleReadWithType {
    public String readAccountNumber() {
        var consoleRead = new ConsoleRead<>(String.class);
        return consoleRead.parse("Account Number: ");
    }

    public String readAccountPassword() {
        var consoleRead = new ConsoleRead<>(String.class);
        return consoleRead.parse("Account Password: ");
    }

    public String readUserAction() {
        var consoleRead = new ConsoleRead<>(String.class);
        return consoleRead.parse("Action: ");
    }

    public String logoutConfirm() {
        var consoleRead = new ConsoleRead<>(String.class);
        return consoleRead.parse("Are you sure you want to logout? yes/no: ");
    }

    public Double addBalance() {
        var consoleRead = new ConsoleRead<>(Double.class);
        return consoleRead.parse("Amount you want to add to your balance: ");
    }

    public Double transferMoneyBalance() {
        var consoleRead = new ConsoleRead<>(Double.class);
        return consoleRead.parse("Amount you want to transfer: ");
    }

    public String transferMoneyAccount() {
        var consoleRead = new ConsoleRead<>(String.class);
        return consoleRead.parse("The received account number: ");
    }

    public String removeAccountConfirm() {
        var consoleRead = new ConsoleRead<>(String.class);
        return consoleRead.parse("Are you sure you want to delete your account? yes/no: ");
    }
}
