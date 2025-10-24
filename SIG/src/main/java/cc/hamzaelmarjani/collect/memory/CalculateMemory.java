package cc.hamzaelmarjani.collect.memory;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

public class CalculateMemory {
    OperatingSystemMXBean osBean;

    public CalculateMemory() {
        this.osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    public String total() {
        var collected = totalBytes() / (1024.0 * 1024 * 1024);
        return String.format("%.1f", collected) + "GB";
    }

    public String available() {
        var free = freeBytes();
        var total = totalBytes();

        var collected = free / (1024.0 * 1024 * 1024);
        var percentage = ((double) free * 100) / total;
        return formatResult(collected, percentage);
    }

    public String used() {
        var free = freeBytes();
        var total = totalBytes();

        var collected = (total - free) / (1024.0 * 1024 * 1024);
        var percentage = ((total - free) * 100) / total;
        return formatResult(collected, percentage);
    }

    private long totalBytes() {
        return osBean.getTotalMemorySize();
    }

    private long freeBytes() {
        return osBean.getFreeMemorySize();
    }

    private String formatResult(double collected, double percentage) {
        return String.format("%.1f", collected) + "GB | " + String.format("%.2f", percentage) + "%";
    }
}
