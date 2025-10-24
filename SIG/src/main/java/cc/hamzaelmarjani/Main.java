package cc.hamzaelmarjani;

import cc.hamzaelmarjani.console.Logger;
import cc.hamzaelmarjani.console.Reader;

public class Main {
    private static final Logger logger = new Logger();
    private static final Reader reader = new Reader();

    static void main() {
        logger.printAppHeeding();
        System.out.println();
        reader.readCommand();
    }
}
