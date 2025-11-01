package com.mycompany.multicastserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastServer {
    static public void main(String args[]) {
        DatagramSocket socket = null;
        BufferedReader in = null;
        boolean moreQuotes = true;
        try {
            socket = new DatagramSocket();
            while (true) {
                InetAddress grupo = InetAddress.getByName("224.2.2.3");
                for (int i = 1; i < 1000; i++) {
                    String dString = i + "--" + (InetAddress.getLocalHost());
                    byte[] buf = dString.getBytes();
                    DatagramPacket packet = new DatagramPacket(buf, buf.length, grupo, 4446);
                    socket.send(packet);
                    try {
                        Thread.currentThread().sleep(200);
                    } catch (InterruptedException e) { }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
