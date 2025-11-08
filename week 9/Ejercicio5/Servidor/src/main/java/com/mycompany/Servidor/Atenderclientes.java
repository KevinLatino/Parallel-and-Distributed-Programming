package com.mycompany.Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Atenderclientes implements Runnable {

    private ObjectInputStream lecturaDatos = null;//Este permite leer los datos que envía el cliente
    private ObjectOutputStream escrituraDatos = null;//Este permite escribir los datos que queremos enviar
    private boolean clienteActivo = true;//Esta variable mantiene el hilo esperando datos
    private List<Atenderclientes> listaClientes;//La lista de todos los clientes

    public Atenderclientes(final Socket conectorCliente, final List<Atenderclientes> listaClientes) {
        try {
            //Con la información de la conexión podemos crear los objetos de lectura y escritura
            lecturaDatos = new ObjectInputStream(conectorCliente.getInputStream());
            escrituraDatos = new ObjectOutputStream(conectorCliente.getOutputStream());
            this.listaClientes = listaClientes;
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //Este método puede enviar los datos desde el server a los clientes
    public void enviarRespuesta(final String dato) {
        try {
            //Para poder enviar los datos usamos el outputStream y escribimos lo que necesitamos
            escrituraDatos.writeUTF(dato);
            escrituraDatos.flush();//Debemos usar el método flush para enviar los datos
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //Los datos que envía el cliente pueden ser leídos por medio de este método.
    private void recibirDatos() {
        try {
            //Leemos los datos y los almacenamos en una variable String
            String info = lecturaDatos.readUTF();
            System.out.println(info);

            //Enviamos el mensaje recibido a cada cliente
            for (Atenderclientes clienteActual : listaClientes) {
                //Cuando encontramos que el cliente es el mismo que recibió el mensaje no enviamos nada
                if (clienteActual != this) {
                    clienteActual.enviarRespuesta(info);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void run() {
        //El hilo siempre va a estar esperando mensajes del cliente
        while (clienteActivo) {
            recibirDatos();
        }
    }
}
