/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class Ejercicio1 extends JFrame implements ActionListener {
    private JTextField tfI;
    private JButton boton1;
    
    public Ejercicio1() {
        setLayout(null);
        tfI = new JTextField("{2*(4-5)-[3*4]-[4-5]}");
        tfI.setBounds(10, 10, 400, 30);
        add(tfI);
        
        boton1 = new JButton("Verificar fórmula.");
        boton1.setBounds(70, 50, 180, 30);
        add(boton1);
        boton1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            if (balanceada()) {
                setTitle("Está correctamente balanceada.");
            } else {
                setTitle("No está correctamente balanceada.");
            }
        }
    }
    
    public boolean balanceada() {
        Stack<Character> pila1 = new Stack<Character>();
        String cadena = tfI.getText();
        
        for (int f = 0; f < cadena.length(); f++) {
            if (cadena.charAt(f) == '(' || cadena.charAt(f) == '{' || cadena.charAt(f) == '[')
                pila1.push(cadena.charAt(f));
            else if (cadena.charAt(f) == ')' || cadena.charAt(f) == '}' || cadena.charAt(f) == ']') {
                if (pila1.isEmpty())
                    return false;
                else if (cadena.charAt(f) == ')' && pila1.pop() != '(')
                    return false;
                else if (cadena.charAt(f) == ']' && pila1.pop() != '[')
                    return false;
                else if (cadena.charAt(f) == '}' && pila1.pop() != '{')
                    return false;
            }
        }
        
        if (pila1.isEmpty())
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) {
        Ejercicio1 formula1 = new Ejercicio1();
        formula1.setBounds(0, 0, 400, 160);
        formula1.setVisible(true);
        formula1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}