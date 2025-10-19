package com.mycompany.ejercicio8;

import javax.swing.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class Imagen2 extends Thread {
    
    boolean activo = true;
    Random img = new Random();
    Random tiem = new Random();
    int i = 0;
    int tiempo = 0;
    int c = 0;
    
    @Override
    public void run() {
        i = 1;
        while (activo == true) {
            tiempo = tiem.nextInt(800);
            
            if (i == 1) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(550, 100);
                i++;
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                c++;
            }
            
            if (i == 2) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(550, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 3) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(550, 300);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 4) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(550, 400);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 5) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(550, 500);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 6) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(550, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 7) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(450, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 8) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(350, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 9) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(250, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 10) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(150, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 11) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(15, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 12) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(15, 500);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 13) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(15, 400);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 14) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(15, 300);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 15) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(15, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 16) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(115, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 17) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(215, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 18) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(315, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 19) {
Interfaz.dos.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img2)));
                Interfaz.dos.setLocation(450, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i = 2;
                c++;
            }
            
            if (c > 50) {
                this.activo = false;
            }
        }
        
        try {
            sleep(tiempo);
        } catch (InterruptedException e) { }
    }
}