package solucionesejercicio4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FormularioBusqueda extends JFrame implements ActionListener {
    JTextArea textareal;
    JScrollPane scrollpanel;
    JButton boton1;

    FormularioBusqueda() {
        setLayout(null);
        textareal = new JTextArea();
        scrollpanel = new JScrollPane(textareal);
        scrollpanel.setBounds(10, 30, 760, 300);
        add(scrollpanel);

        boton1 = new JButton("Salir");
        boton1.addActionListener(this);
        boton1.setBounds(320, 350, 100, 30);
        add(boton1);

        textareal.setText("");
        HiloBusqueda hb = new HiloBusqueda("C:\\", textareal);
        hb.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1)
            System.exit(0);
    }

    public static void main(String[] args) {
        FormularioBusqueda fb;
        fb = new FormularioBusqueda();
        fb.setBounds(0, 0, 800, 640);
        fb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fb.setVisible(true);
    }
}
