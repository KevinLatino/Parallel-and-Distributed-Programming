package com.mycompany.Servidor;

public class Iniciarservicio {

    public static void main(String[] args) {
        Esperarclientes servidor = new Esperarclientes();
        //Vamos a estar enviando mensajes siempre
        while (true) {
            servidor.realizarConexion();
        }
    }
}
