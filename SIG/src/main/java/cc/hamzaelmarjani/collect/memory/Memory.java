package cc.hamzaelmarjani.collect.memory;

import cc.hamzaelmarjani.console.Logger;

public class Memory extends CalculateMemory {
    private final Logger logger = new Logger();

    public void run() {
        MemoryInfo memoryInfo = new MemoryInfo(
                super.total(),
                super.available(),
                super.used()
        );
        logger.printMemoryInfo(memoryInfo);
    }
}
