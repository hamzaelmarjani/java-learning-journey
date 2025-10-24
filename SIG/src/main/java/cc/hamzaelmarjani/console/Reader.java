package cc.hamzaelmarjani.console;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Reader {
    private final Logger logger;
    private final Scanner scanner;
    private Collection<Character> commands;

    public Reader() {
        this.scanner = new Scanner(System.in);
        this.logger = new Logger();
        initCommands();
    }

    private void initCommands() {
        commands = new ArrayList<>();
        // TODO: The new commands characters which will be added in the future
        // TODO: String commandsChars = "QXACMDNOPUHBKL";
        String commandsChars = "QXACMDN";
        for (var c = 0; c < commandsChars.length(); c++) {
            commands.add(commandsChars.charAt(c));
        }
    }

    public void readCommand() {
        System.out.print("Command: ");
        var command = scanner.next();
        if (command.length() != 1 || !commands.contains(command.charAt(0))) {
            logger.printInvalidCommand();
            readCommand();
        } else {
            char commandChar = command.charAt(0);
            Parser parser = new Parser(commandChar);
            parser.parseCommand();
        }
    }
}
