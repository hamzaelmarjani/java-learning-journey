package cc.hamzaelmarjani.collect.network;

import cc.hamzaelmarjani.console.Logger;

public class Network extends CollectNetwork {
    private final Logger logger = new Logger();

    public void run() {
        NetworkInfo networkInfo = new NetworkInfo(
                super.getInterfacesList(),
                super.getInterfacesAddresses(),
                super.getMacAddress()
        );
        logger.printNetworkInfo(networkInfo);
    }
}
