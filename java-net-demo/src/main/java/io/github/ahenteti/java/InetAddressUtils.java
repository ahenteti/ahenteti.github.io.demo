package io.github.ahenteti.java;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * InetAddress Utils
 */
public class InetAddressUtils {

    /**
     * Finds a local, non-loopback address
     * 
     * @return The first non-loopback found, or <code>null</code> if no
     *         such addresses found
     * @throws SocketException If there was a problem querying the network
     *                         interfaces
     */
    public static InetAddress getLocalAddress() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            Enumeration<InetAddress> addresses = iface.getInetAddresses();

            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if (!addr.isLoopbackAddress()) {
                    return addr;
                }
            }
        }

        return null;
    }
}
