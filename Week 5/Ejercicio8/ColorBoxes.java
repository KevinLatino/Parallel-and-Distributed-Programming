package colorboxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorBoxes extends JFrame {

    public ColorBoxes(int pause, int grosor_punto) {
        setTitle("ColorBoxes");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(grosor_punto, grosor_punto));

        // Crear la grilla de CBox
        for (int i = 0; i < grosor_punto * grosor_punto; i++) {
            cp.add(new CBox(pause));
        }

        // Cerrar aplicación al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        int pause = 5000;          // Máximo de espera aleatoria (ms)
        int grosor_punto = 20;     // Cantidad de celdas por lado

        if (args.length > 0) {
            try { pause = Integer.parseInt(args[0]); } catch (NumberFormatException ignored) {}
        }
        if (args.length > 1) {
            try { grosor_punto = Integer.parseInt(args[1]); } catch (NumberFormatException ignored) {}
        }

        JFrame frame = new ColorBoxes(pause, grosor_punto);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
