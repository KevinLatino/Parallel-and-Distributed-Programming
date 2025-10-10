package com.mycompany.carreradeautos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class Carrera extends JFrame {
    private Auto auto1, auto2;
    private int meta;

    public Carrera() {
        setTitle("Carrera de Autos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los autos
        auto1 = new Auto(10, Color.RED, 100);
        auto2 = new Auto(10, Color.BLUE, 200);
        meta = getWidth() - 70;

        // Iniciar los hilos
        auto1.setMeta(meta);
        auto2.setMeta(meta);
        auto1.setFrame(this);
        auto2.setFrame(this);

        new Thread(auto1).start();
        new Thread(auto2).start();

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibujar línea de meta
        g.drawLine(meta, 0, meta, getHeight());
        // Dibujar los autos
        auto1.dibujar(g);
        auto2.dibujar(g);
    }
}

class Auto implements Runnable {
    private int velocidad;
    private int posicion;
    private Color color;
    private int y;
    private int meta;
    private JFrame frame;

    public Auto(int velocidad, Color color, int y) {
        this.velocidad = velocidad;
        this.color = color;
        this.y = y;
        this.posicion = 10;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(posicion, y, 30, 20);
    }

    @Override
    public void run() {
        Random random = new Random();
        while (posicion < meta - 30) {
            try {
                Thread.sleep(100 + random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            posicion += velocidad + random.nextInt(10);
            frame.repaint();
        }
    }
}
