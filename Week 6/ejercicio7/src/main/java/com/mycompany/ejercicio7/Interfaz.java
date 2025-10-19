package com.mycompany.ejercicio7;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    
    JButton detener1 = new JButton("Detener");
    JButton detener2 = new JButton("Detener");
    JButton detener3 = new JButton("Detener");
    JButton iniciar = new JButton("Iniciar");
    JButton detenerTodo = new JButton("Detener Todo");
    
    public static String img0 = "Pista.jpg";
    public static String img1 = "carro1.jpg";
    public static String img2 = "carro2.jpg";
    public static String img3 = "carro3.jpg";
    
    public static JLabel cero = new JLabel();
    public static JLabel uno = new JLabel();
    public static JLabel dos = new JLabel();
    public static JLabel tres = new JLabel();
    
    JPanel controles = new JPanel();
    JPanel imagenes = new JPanel();
    
    Imagen1 hilo1 = new Imagen1();
    Imagen2 hilo2 = new Imagen2();
    Imagen3 hilo3 = new Imagen3();
    int z = 0;
    
    public Interfaz() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Cargar imágenes desde la carpeta resources
        cero.setIcon(new ImageIcon(getClass().getResource("/resources/" + img0)));
        uno.setIcon(new ImageIcon(getClass().getResource("/resources/" + img1)));
        dos.setIcon(new ImageIcon(getClass().getResource("/resources/" + img2)));
        tres.setIcon(new ImageIcon(getClass().getResource("/resources/" + img3)));
        
        imagenes.setLayout(new FlowLayout());
        imagenes.add(uno);
        imagenes.add(dos);
        imagenes.add(tres);
        
        controles.setLayout(new GridLayout(2, 3));
        controles.add(detener1);
        controles.add(detener2);
        controles.add(detener3);
        controles.add(iniciar);
        controles.add(detenerTodo);
        imagenes.add(cero);
        
        add("Center", imagenes);
        add("South", controles);
        
        // ActionListener para el botón Iniciar
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (hilo1.isAlive() == false) {
                    if (hilo2.isAlive() == false) {
                        if (hilo3.isAlive() == false) {
                            hilo1 = new Imagen1();
                            hilo2 = new Imagen2();
                            hilo3 = new Imagen3();
                            hilo1.activo = true;
                            hilo2.activo = true;
                            hilo3.activo = true;
                            hilo1.start();
                            hilo2.start();
                            hilo3.start();
                            z = 1;
                        }
                    }
                }
            }
        });
        
        // ActionListener para Detener Todo
        detenerTodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (z == 1) {
                    hilo1.activo = false;
                    hilo2.activo = false;
                    hilo3.activo = false;
                    
                    if (hilo1.c == hilo2.c) {
                        if (hilo2.c == hilo3.c) {
                            JOptionPane.showMessageDialog(Interfaz.this, "Ganador ! ! ! ");
                        }
                    }
                }
            }
        });
        
        // ActionListener para detener1
        detener1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hilo1.activo = false;
            }
        });
        
        // ActionListener para detener2
        detener2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hilo2.activo = false;
            }
        });
        
        // ActionListener para detener3
        detener3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hilo3.activo = false;
            }
        });
    }
}