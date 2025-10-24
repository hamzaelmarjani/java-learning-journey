package cc.hamzaelmarjani.collect.cpu;

import cc.hamzaelmarjani.collect.cmd.CmdRunner;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class CPUOperations {
    private final CmdRunner cmdRunner = new CmdRunner();
    OperatingSystemMXBean osBean;

    public CPUOperations() {
        this.osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    /// Getting the physical cores of the running device.
    /// I use command on MacOSX or Linux, because `Runtime.getRuntime().availableProcessors()` on Java returns logical cores, which includes physical cores × threads per core (Hyper-Threading on Intel CPUs)
    /// If this method failed on anyway and under any exception, the default return value is 0.
    public short getPhysicalCores() {
        short cores;
        String os = System.getProperty("os.name").toLowerCase();
        String[] command;


        if (os.contains("mac")) {
            command = new String[]{"sysctl", "-n", "hw.physicalcpu"};
        } else {
            // I only test on MacOSX, I don't have Windows or Linux. Sorry guys 😇
            // So this is not an error, this is just an environment problem, this is why I'll return 0.
            return 0;
        }

        var output = cmdRunner.runCmd(command);

        try {
            cores = Short.parseShort(output);
        } catch (NumberFormatException e) {
            cores = 0;
        }
        return cores;
    }

    public String getVendorAndModelName() {
        String os = System.getProperty("os.name").toLowerCase();
        String[] command;

        if (os.contains("mac")) {
            command = new String[]{"sysctl", "-n", "machdep.cpu.brand_string"};
        } else {
            // I only test on MacOSX, I don't have Windows or Linux. Sorry guys 😇
            // So this is not an error, this is just an environment problem, this is why I'll return "unknown".
            return "unknown";
        }
        return cmdRunner.runCmd(command);
    }

    public String getLoad() {
        return String.format("%.2f", osBean.getSystemLoadAverage()) + "%";
    }

    public String getArch() {
        return System.getProperty("os.arch");
    }
}
