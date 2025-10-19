package com.mycompany.ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Obstaculos implements Runnable {
    
    @Override
    public void run() {
        while (Ejecutor.systemIsAlive) {
            try {
                // Generar coordenadas aleatorias para colocar obstáculos
                int x = (int) (Math.random() * 5);  // Equipo (0-4)
                int y = (int) (Math.random() * 10); // Posición (0-9)
                int obsNumber = (int) (Math.random() * 4); // Tipo de obstáculo (0-3)
                
                System.out.println("Obstacles Team -> " + (x + 1) + 
                                 " position -> " + (y + 1) + 
                                 " obsNumber-> " + obsNumber);
                
                // Asignar tiempo de retraso según el tipo de obstáculo
                switch (obsNumber) {
                    case 0:
                        Ejecutor.obstacles[x][y] = 0;
                        break;
                    case 1:
                        Ejecutor.obstacles[x][y] = 100;
                        break;
                    case 2:
                        Ejecutor.obstacles[x][y] = 300;
                        break;
                    case 3:
                        Ejecutor.obstacles[x][y] = 1000;
                        break;
                    default:
                        Ejecutor.obstacles[x][y] = 0;
                        break;
                }
                
                // Esperar 2 segundos antes de generar el siguiente obstáculo
                Thread.sleep(2000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Obstaculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}