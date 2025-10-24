package cc.hamzaelmarjani.collect.disk;

import cc.hamzaelmarjani.console.Logger;

public class Disk extends DiskOperations {
    private final Logger logger = new Logger();

    public void run() {
        DiskInfo diskInfo = new DiskInfo(
                super.getMountedVolumes(),
                super.getTotal(),
                super.getFree(),
                super.getUsable(),
                super.getFSType()
        );
        logger.printDiskInfo(diskInfo);
    }
}
