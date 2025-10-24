package cc.hamzaelmarjani.collect.cpu;

import cc.hamzaelmarjani.console.Logger;

public class CPU extends CPUOperations {
    private final Logger logger = new Logger();

    public void run() {
        CPUInfo cpuInfo = new CPUInfo(
                super.getPhysicalCores(),
                super.getArch(),
                super.getVendorAndModelName(),
                super.getLoad()
        );
        logger.printCPUInfo(cpuInfo);
    }
}
