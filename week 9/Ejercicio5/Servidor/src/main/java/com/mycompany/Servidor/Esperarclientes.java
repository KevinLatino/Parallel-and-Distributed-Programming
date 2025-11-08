package com.mycompany.Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Esperarclientes {

    private ServerSocket conexion;//Este objeto nos permite establecer la conexión con el usuario
    private Socket conectorCliente;//Cuando la conexión se estable vamos a tener los datos del conectorCliente
    private ExecutorService service;
    private List<Atenderclientes> listaClientes;//La lista de todos los clientes

    public Esperarclientes() {
        try {
            conexion = new ServerSocket(8670);
            listaClientes = new ArrayList<>();
            service = Executors.newCachedThreadPool();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //Debemos esperar que un conectorCliente quiera conectarse al servidor
    public void realizarConexion() {
        try {
            conectorCliente = conexion.accept();//El método accept espera la conexión del conectorCliente
            //Tenemos que crear un hilo por cada conectorCliente y enviarle el dato de
            //la conexión que construimos con el método accept
            Atenderclientes clienteRemoto = new Atenderclientes(conectorCliente, listaClientes);
            listaClientes.add(clienteRemoto);//Agregamos el conectorCliente a la lista
            service.submit(clienteRemoto);//Ejecutamos el conectorCliente
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
