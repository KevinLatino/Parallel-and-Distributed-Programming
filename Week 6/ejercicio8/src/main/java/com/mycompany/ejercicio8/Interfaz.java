package com.mycompany.ejercicio8;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    
    // Botones de control
    JButton detener1 = new JButton("Detener 1");
    JButton detener2 = new JButton("Detener 2");
    JButton detener3 = new JButton("Detener 3");
    JButton detener4 = new JButton("Detener 4");
    JButton iniciar = new JButton("Iniciar");
    JButton detenerTodo = new JButton("Detener Todo");
    
    // Nombres de las imágenes
    public static String img0 = "Pista.jpg";
    public static String img1 = "carro1.jpg";
    public static String img2 = "carro2.jpg";
    public static String img3 = "carro3.jpg";
    public static String img4 = "carro4.jpg";
    
    // Labels para mostrar los carros
    public static JLabel cero = new JLabel();
    public static JLabel uno = new JLabel();
    public static JLabel dos = new JLabel();
    public static JLabel tres = new JLabel();
    public static JLabel cuatro = new JLabel();
    
    JPanel controles = new JPanel();
    JPanel imagenes = new JPanel();
    
    // Los 4 hilos de los carros
    Imagen1 hilo1 = new Imagen1();
    Imagen2 hilo2 = new Imagen2();
    Imagen3 hilo3 = new Imagen3();
    Imagen4 hilo4 = new Imagen4();
    int z = 0;
    
    public Interfaz() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Cargar imágenes desde la carpeta resources
        cero.setIcon(new ImageIcon(getClass().getResource("/resources/" + img0)));
        uno.setIcon(new ImageIcon(getClass().getResource("/resources/" + img1)));
        dos.setIcon(new ImageIcon(getClass().getResource("/resources/" + img2)));
        tres.setIcon(new ImageIcon(getClass().getResource("/resources/" + img3)));
        cuatro.setIcon(new ImageIcon(getClass().getResource("/resources/" + img4)));
        
        imagenes.setLayout(new FlowLayout());
        imagenes.add(uno);
        imagenes.add(dos);
        imagenes.add(tres);
        imagenes.add(cuatro);
        
        // Panel de controles con grid 2x3
        controles.setLayout(new GridLayout(2, 3));
        controles.add(detener1);
        controles.add(detener2);
        controles.add(detener3);
        controles.add(detener4);
        controles.add(iniciar);
        controles.add(detenerTodo);
        
        imagenes.add(cero);
        
        add("Center", imagenes);
        add("South", controles);
        
        // ActionListener para el botón Iniciar
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (!hilo1.isAlive() && !hilo2.isAlive() && 
                    !hilo3.isAlive() && !hilo4.isAlive()) {
                    
                    // Crear nuevos hilos
                    hilo1 = new Imagen1();
                    hilo2 = new Imagen2();
                    hilo3 = new Imagen3();
                    hilo4 = new Imagen4();
                    
                    // Activar todos los carros
                    hilo1.activo = true;
                    hilo2.activo = true;
                    hilo3.activo = true;
                    hilo4.activo = true;
                    
                    // Iniciar la carrera
                    hilo1.start();
                    hilo2.start();
                    hilo3.start();
                    hilo4.start();
                    z = 1;
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
                    hilo4.activo = false;
                    
                    // Verificar si hay empate entre los 4 carros
                    if (hilo1.c == hilo2.c && hilo2.c == hilo3.c && hilo3.c == hilo4.c) {
                        JOptionPane.showMessageDialog(Interfaz.this, "¡Empate perfecto entre los 4 carros!");
                    } else {
                        // Determinar el ganador
                        int max = Math.max(Math.max(hilo1.c, hilo2.c), Math.max(hilo3.c, hilo4.c));
                        String ganador = "";
                        
                        if (hilo1.c == max) ganador += "Carro 1 ";
                        if (hilo2.c == max) ganador += "Carro 2 ";
                        if (hilo3.c == max) ganador += "Carro 3 ";
                        if (hilo4.c == max) ganador += "Carro 4 ";
                        
                        JOptionPane.showMessageDialog(Interfaz.this, 
                            "¡Ganador(es): " + ganador + "!\n" +
                            "Carro 1: " + hilo1.c + " movimientos\n" +
                            "Carro 2: " + hilo2.c + " movimientos\n" +
                            "Carro 3: " + hilo3.c + " movimientos\n" +
                            "Carro 4: " + hilo4.c + " movimientos");
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
        
        // ActionListener para detener4
        detener4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hilo4.activo = false;
            }
        });
    }
}