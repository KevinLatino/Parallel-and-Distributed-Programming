package com.mycompany.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {

        DatagramSocket socket = new DatagramSocket(32000);

        String msj = "Hola Server.....";
        String ip = "127.0.0.1";
        int port = 45000;

        DatagramPacket paqueteEnvio = new DatagramPacket(msj.getBytes(),
                msj.length(), InetAddress.getByName(ip), port);

        socket.send(paqueteEnvio);

        byte[] resp = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(resp, 1024);

        socket.receive(paqueteRecibido);

        System.out.println("Server respondio desde "
                + paqueteRecibido.getAddress().getHostAddress()
                + " por el puerto " + paqueteRecibido.getPort()
                + " se recibio:" + new String(paqueteRecibido.getData()));

        // 5. cerrar
        socket.close();
    }
}
