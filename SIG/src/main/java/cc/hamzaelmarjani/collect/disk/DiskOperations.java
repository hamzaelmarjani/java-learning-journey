package cc.hamzaelmarjani.collect.disk;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;

public class DiskOperations {
    public String getTotal() {
        var root = getRoot();
        double total = root.getTotalSpace() / (1024.0 * 1024 * 1024);
        return String.format("%.1f", total) + "GB";
    }

    public String getFree() {
        var root = getRoot();
        double free = root.getFreeSpace() / (1024.0 * 1024 * 1024);
        return String.format("%.1f", free) + "GB";
    }

    public String getUsable() {
        var root = getRoot();
        double usable = (root.getTotalSpace() - root.getFreeSpace()) / (1024.0 * 1024 * 1024);
        return String.format("%.1f", usable) + "GB";
    }

    public String getMountedVolumes() {
        StringBuilder volumes = new StringBuilder();

        for (FileStore store : FileSystems.getDefault().getFileStores()) {
            volumes
                    .append(volumes.isEmpty() ? "" : " - ")
                    .append(store.name());
        }

        return volumes.toString();
    }

    public String getFSType() {
        var root = getRoot();
        String type = "unknown";

        for (FileStore store : FileSystems.getDefault().getFileStores()) {
            try {
                if (store.getTotalSpace() == root.getTotalSpace()) {
                    type = store.type();
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return type;
    }

    private File getRoot() {
        String os = System.getProperty("os.name").toLowerCase();
        String path;
        if (os.contains("mac") || os.contains("linux")) {
            path = "/";
        } else {
            path = "C:\\";
        }
        return new File(path);
    }
}
