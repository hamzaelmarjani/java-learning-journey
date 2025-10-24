package cc.hamzaelmarjani.console;

import cc.hamzaelmarjani.collect.cpu.CPUInfo;
import cc.hamzaelmarjani.collect.disk.DiskInfo;
import cc.hamzaelmarjani.collect.memory.MemoryInfo;
import cc.hamzaelmarjani.collect.network.NetworkInfo;

public class Logger {
    public void printAppHeeding() {
        System.out.println("******* Systems Information Gathering *******");
        System.out.println();

        System.out.println("\uD83D\uDDA5\uFE0F Welcome! Please choose what information you want to display from the menu below:");
        System.out.println();
        printMenu();
    }

    public void printMenu() {
        System.out.println("Q: Quit • X: Clear • A: All Information • C: CPU • M: Memory • D: Disk & Filesystems • N: Network");
        // TODO: The new commands characters which will be added in the future
        // TODO: System.out.println("O: Operating System • P: Processes & Threads • U: Users & Sessions • H: Hardware & System Board • B: Power & Battery • K: Kernel Features • L: Locale, Time & Regional");
    }

    public void printInvalidCommand() {
        System.out.println();
        System.out.println("\uD83D\uDD34 Invalid command, please check again!");
        System.out.println();
        printMenu();
        System.out.println();
    }

    public void printExitProgram() {
        System.out.println("Thanks for your visit, see you \uD83D\uDC4B");
        System.out.println();
    }

    public void printCPUInfo(CPUInfo info) {
        System.out.println();
        System.out.println("\uD83D\uDD32 CPU Info Gathering");
        System.out.println("-- -- -- -- -- -- -- --");
        System.out.println("• CPU Physical Cores: " + info.cores() + " Cores");
        System.out.println("• CPU Load: " + info.load());
        System.out.println("• CPU Architecture: " + info.arch());
        System.out.println("• CPU Vendor and Model Name: " + info.vendorAndModelName());
        System.out.println();
    }

    public void printMemoryInfo(MemoryInfo info) {
        System.out.println();
        System.out.println("\uD83D\uDCBE Memory Info Gathering");
        System.out.println("-- -- -- -- -- -- -- --");
        System.out.println("• Total Memory: " + info.total());
        System.out.println("• Available Memory: " + info.available());
        System.out.println("• Used Memory: " + info.used());
        System.out.println();
    }

    public void printNetworkInfo(NetworkInfo info) {
        System.out.println();
        System.out.println("\uD83C\uDF10 Network Info Gathering");
        System.out.println("-- -- -- -- -- -- -- --");
        System.out.println("• Network Interfaces List: " + info.interfacesList());
        System.out.println("• Network Interfaces Addresses: " + info.interfacesAddresses());
        System.out.println("• Hardware MAC Address: " + info.macAddress());
        System.out.println();
    }

    public void printDiskInfo(DiskInfo info) {
        System.out.println();
        System.out.println("\uD83D\uDCBD Disk Info Gathering");
        System.out.println("-- -- -- -- -- -- -- --");
        System.out.println("• Mounted Volumes: " + info.mountedVolumes());
        System.out.println("• Hard Drive Total Space: " + info.total());
        System.out.println("• Hard Drive Free Space: " + info.free());
        System.out.println("• Hard Drive Usable Space: " + info.usable());
        System.out.println("• Hard Drive Type: " + info.type());
        System.out.println();
    }
}
