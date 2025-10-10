package colorboxes;

import javax.swing.*;
import java.awt.*;

class CBox extends JPanel implements Runnable {
    private Thread t;
    private int pause;

    // Paleta de colores disponible
    private static final Color[] colors = new Color[]{
        Color.BLACK, Color.BLUE, Color.CYAN,
        Color.DARK_GRAY, Color.GRAY, Color.GREEN,
        Color.LIGHT_GRAY, Color.MAGENTA,
        Color.ORANGE, Color.PINK, Color.RED,
        Color.WHITE, Color.YELLOW
    };

    private Color cColor = newColor();

    private static Color newColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    public CBox(int pause) {
        this.pause = pause;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(cColor);
        Dimension s = getSize();
        g.fillRect(0, 0, s.width, s.height);
    }

    @Override
    public void run() {
        while (true) {
            cColor = newColor();
            repaint();
            try {
                Thread.sleep((int) (Math.random() * pause));
            } catch (InterruptedException e) {
                // Ignorar y continuar
            }
        }
    }
}
