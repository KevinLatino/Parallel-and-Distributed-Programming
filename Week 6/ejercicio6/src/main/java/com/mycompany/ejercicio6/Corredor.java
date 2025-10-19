package com.mycompany.ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor implements Runnable {
    
    private final int runnerId;
    private int position = 0;
    private final long sleepTime = 1000;
    private long obstacle = 0;
    private boolean runnerRunning = true;
    private final int team;
    
    public Corredor(final int runnerId, final int team) {
        this.runnerId = runnerId;
        this.team = team;
    }
    
    @Override
    public void run() {
        while (Ejecutor.systemIsAlive && runnerRunning) {
            try {
                if (position < 10) {
                    // Obtener el obstáculo en la posición actual
                    obstacle = Ejecutor.obstacles[team - 1][position];
                    position++;
                    System.out.println("Team-> " + team + " Runner-> " + runnerId + 
                                     " Position-> " + position);
                } else if (runnerId == 6) {
                    // Si es el corredor 6, detener el sistema
                    Ejecutor.systemIsAlive = false;
                    Ejecutor.service.shutdown();
                } else {
                    // El corredor terminó su recorrido
                    this.runnerRunning = false;
                    // Crear un nuevo corredor para el mismo equipo
                    Ejecutor.service.submit(new Corredor(this.runnerId + 1, this.team));
                }
                // Dormir según el obstáculo encontrado
                Thread.sleep(sleepTime + obstacle);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}