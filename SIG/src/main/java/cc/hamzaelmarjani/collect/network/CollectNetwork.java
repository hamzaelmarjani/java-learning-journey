package cc.hamzaelmarjani.collect.network;

import java.net.*;
import java.util.Enumeration;

public class CollectNetwork {
    public String getInterfacesList() {
        StringBuilder listInterfaces = new StringBuilder();
        var interfaces = getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface netIf = interfaces.nextElement();
            listInterfaces
                    .append(listInterfaces.isEmpty() ? "" : " - ")
                    .append(netIf.getName())
                    .append("(")
                    .append(getInterfaceReadableName(netIf))
                    .append(")");
        }
        return listInterfaces.toString();
    }

    public String getInterfacesAddresses() {
        StringBuilder listAddressesIPv4 = new StringBuilder().append("IPv4:");
        StringBuilder listAddressesIPv6 = new StringBuilder().append("IPv6:");

        var interfaces = getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface netIf = interfaces.nextElement();
            Enumeration<InetAddress> addresses = netIf.getInetAddresses();

            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                if (address instanceof Inet4Address) {
                    listAddressesIPv4
                            .append(listAddressesIPv4.toString().equals("IPv4:") ? " " : " - ")
                            .append(address.getHostAddress());
                } else if (address instanceof Inet6Address) {
                    listAddressesIPv6
                            .append(listAddressesIPv6.toString().equals("IPv6:") ? " " : " - ")
                            .append(address.getHostAddress());
                }
            }
        }

        return listAddressesIPv4 + " | " + listAddressesIPv6;
    }

    public String getMacAddress() {
        String macAddress = "unknown";
        try {
            var interfaces = getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface netIf = interfaces.nextElement();

                byte[] mac = netIf.getHardwareAddress();

                if (mac != null) {
                    StringBuilder macStr = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macStr.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
                    }
                    macAddress = macStr.toString();
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        return macAddress;
    }

    private static String getInterfaceReadableName(NetworkInterface netIf) {
        String name = netIf.getName().toLowerCase();
        String displayName = (netIf.getDisplayName() != null ? netIf.getDisplayName().toLowerCase() : "");
        String os = System.getProperty("os.name").toLowerCase();

        if (name.startsWith("wl") || name.startsWith("wlan") || name.startsWith("wifi")
                || displayName.contains("wi-fi") || displayName.contains("wireless")) {
            return "Wi-Fi";
        }

        if (os.contains("mac") && (name.equals("en0") || name.equals("en1"))
                && !displayName.contains("ethernet") && !displayName.contains("usb")) {
            return "Wi-Fi";
        }

        if (name.startsWith("en") || name.startsWith("eth")
                || displayName.contains("ethernet") || displayName.contains("lan")) {
            return "Ethernet";
        }

        return "Other";
    }

    private Enumeration<NetworkInterface> getNetworkInterfaces() {
        try {
            return NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
