package com.mycompany.ejercicio7;

import javax.swing.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class Imagen1 extends Thread {
    
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
            tiempo = tiem.nextInt(750);
            
            if (i == 1) {
                Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(550, 100);
                i++;
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                c++;
            }
            
            if (i == 2) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(550, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 3) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(550, 300);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 4) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(550, 400);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 5) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(550, 500);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 6) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(550, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 7) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(450, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 8) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(350, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 9) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(250, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 10) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(150, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 11) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(15, 575);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 12) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(15, 500);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 13) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(15, 400);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 14) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(15, 300);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 15) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(15, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 16) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(115, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 17) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(215, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 18) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(315, 200);
                try {
                    sleep(tiempo);
                } catch (InterruptedException e) { }
                i++;
                c++;
            }
            
            if (i == 19) {
Interfaz.uno.setIcon(new ImageIcon(Interfaz.class.getResource("/resources/" + Interfaz.img1)));
                Interfaz.uno.setLocation(450, 200);
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