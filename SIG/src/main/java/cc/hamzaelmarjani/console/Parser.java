package cc.hamzaelmarjani.console;

import cc.hamzaelmarjani.collect.cpu.CPU;
import cc.hamzaelmarjani.collect.disk.Disk;
import cc.hamzaelmarjani.collect.memory.Memory;
import cc.hamzaelmarjani.collect.network.Network;
import cc.hamzaelmarjani.utils.CommandUtils;
import cc.hamzaelmarjani.utils.ThreadUtils;

public class Parser {
    private final ThreadUtils threadsUtils = new ThreadUtils();
    private final Logger logger = new Logger();
    private final Reader reader = new Reader();
    private final CommandUtils commandUtils = new CommandUtils();

    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final Network network = new Network();
    private final Disk disk = new Disk();

    private final char command;

    public Parser(char command) {
        this.command = command;
    }

    public void parseCommand() {
        switch (command) {
            case 'A':
                cpu.run();
                memory.run();
                network.run();
                disk.run();
                reader.readCommand();
                break;
            case 'C':
                cpu.run();
                reader.readCommand();
                break;
            case 'M':
                memory.run();
                reader.readCommand();
                break;
            case 'N':
                network.run();
                reader.readCommand();
                break;
            case 'D':
                disk.run();
                reader.readCommand();
                break;
            case 'X':
                commandUtils.fakeClearConsole(30);
                threadsUtils.sleep(50);
                reader.readCommand();
                break;
            case 'Q':
                logger.printExitProgram();
                threadsUtils.sleep(250);
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
