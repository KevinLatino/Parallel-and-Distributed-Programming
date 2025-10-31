package com.mycompany.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Servidor {

    public static void main(String[] args) {

        try {
            System.out.println("server creado.......");
            DatagramSocket socket = new DatagramSocket(45000);

            byte[] buffer = new byte[1024];
            DatagramPacket paqueteCliente = new DatagramPacket(buffer, 1024);
            System.out.println("socket esperando....");
            socket.receive(paqueteCliente);

            String msj = new String(paqueteCliente.getData());

            System.out.println("desde "
                + paqueteCliente.getAddress().getHostAddress()
                + " desde el puerto " + paqueteCliente.getPort()
                + " se recibio:" + msj);

            String resp = new Date().toString(); 

            InetAddress addr = paqueteCliente.getAddress(); 
            int port = paqueteCliente.getPort();

            DatagramPacket paqueteEnvio = new DatagramPacket(resp.getBytes(),
                    resp.length(), addr, port);

            System.out.println("enviando:" + new String(paqueteEnvio.getData()));
            socket.send(paqueteEnvio);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
