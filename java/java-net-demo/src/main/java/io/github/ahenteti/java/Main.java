package io.github.ahenteti.java;

import java.net.InetAddress;
import java.net.SocketException;

/**
 * Main class
 */
class Main {
    public static void main(String[] args) throws SocketException {
      InetAddress localAddress = InetAddressUtils.getLocalAddress();
      System.out.println(localAddress);
    }
}