package com.mycompany.ejercicio1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class Ejercicio1 {
    void cantar() {
        JOptionPane.showMessageDialog(null, "Cantando: Ese toro enamorado de la luna...");
        System.out.println("Cantando: Ese toro enamorado de la luna...");
    }

    void silbar() {
        JOptionPane.showMessageDialog(null, "Silbando: Fiiuuu, Fiiuuu, Fiiiuuu...");
        System.out.println("Silbando: Fiiuuu, Fiiuuu, Fiiiuuu...");
    }

    public static void main(String[] args) {
        Ejercicio1 app = new Ejercicio1();
        Acciones ejecutar = app.new Acciones();
    }

    class Acciones extends Frame {
        class CantarActionListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                cantar();
            }
        }

        class SilbarActionListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                silbar();
            }
        }

        class Cerrar extends WindowAdapter {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        }

        public Acciones() {
            setLayout(new FlowLayout());
            setTitle("Java Clases Anidadas");
            Button botonCantar;
            add(botonCantar = new Button("Cantar"));
            botonCantar.addActionListener(new CantarActionListener());
            Button botonSilbar;
            add(botonSilbar = new Button("Silbar"));
            botonSilbar.addActionListener(new SilbarActionListener());
            addWindowListener(new Cerrar());
            setSize(300, 75);
            setVisible(true);
        }
    }
}
