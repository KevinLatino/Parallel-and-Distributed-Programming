package com.mycompany.Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Hilocliente extends Thread {

    private Socket conectorServidor;//Cuando la conexión se establece vamos a tener los datos del conectorServidor
    private ObjectInputStream lecturaDatos;//Este permite leer los datos que envía el conectorServidor
    private ObjectOutputStream escrituraDatos;//Este permite escribir los datos que queremos enviar
    private boolean clienteActivo = true;//Esta variable mantiene el hilo esperando datos
    private String usuario;//Nombre del usuario que se va a visualizar

    public Hilocliente(final String usuario) {
        try {
            //Aquí hacemos la conexión con el servidor. Si trabajamos en la misma
            //maquina podemos usar la dirección 127.0.0.1 y
            //debemos usar el mismo puerto que seleccionamos en el servidor
            conectorServidor = new Socket(InetAddress.getByName("127.0.0.1"), 8670);
            this.usuario = usuario;
            inicializarFlujosDatos();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //Después de establecer la conexión con el servidor podemos inicializar los
    //flujos de datos para enviar y recibir información.
    private void inicializarFlujosDatos() {
        try {
            //Creamos los flujos de datos con la información de la conexión del servidor
            escrituraDatos = new ObjectOutputStream(conectorServidor.getOutputStream());
            lecturaDatos = new ObjectInputStream(conectorServidor.getInputStream());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //Este método nos permite enviar los datos al servidor
    public void enviarDatos() {
        try {
            System.out.print("Escriba su mensaje: ");
            Scanner leer = new Scanner(System.in);
            String mensaje = leer.nextLine();
            escrituraDatos.writeUTF(usuario + ": " + mensaje);//Escribimos la información que deseamos pasar
            escrituraDatos.flush();//Debemos usar el método flush para enviar los datos
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //Vamos a esperar los datos del servidor
    private void recibirDatos() {
        try {
            String info = lecturaDatos.readUTF();//Vamos a leer los datos que nos envia el server
            System.out.println(info);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void run() {
        //El hilo siempre va a estar esperando mensajes del servidor
        while (clienteActivo) {
            recibirDatos();
            System.out.print("Escriba su respuesta: ");
        }
    }
}
