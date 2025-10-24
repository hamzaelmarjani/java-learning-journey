package cc.hamzaelmarjani.collect.disk;

public record DiskInfo(
        String mountedVolumes,
        String total,
        String free,
        String usable,
        String type
) {
}
