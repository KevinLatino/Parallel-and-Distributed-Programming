package pelotarebota;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PelotaRebota {
    public static void main(String[] args) {
        JFrame marco = new MarcoRebote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

// ---------------------- Modelo de la Pelota ----------------------
class Pelota implements Runnable {
    // Tamaño
    private static final int TAMX = 40;
    private static final int TAMY = 40;

    // Posición inicial y velocidad
    private double x = 50;
    private double y = 50;
    private double dx = 2;
    private double dy = 2;

    private final LaminaPelota lienzo;
    private volatile boolean running = true;
    private final Random rand = new Random();

    public Pelota(LaminaPelota lienzo) {
        this.lienzo = lienzo;
        // Aleatorizar dirección inicial
        dx = 2 + rand.nextInt(4);
        dy = 2 + rand.nextInt(4);
        if (rand.nextBoolean()) dx = -dx;
        if (rand.nextBoolean()) dy = -dy;
        // Posición aleatoria dentro del panel
        Rectangle bounds = lienzo.getBounds();
        x = Math.max(0, rand.nextInt(Math.max(1, bounds.width - TAMX)));
        y = Math.max(0, rand.nextInt(Math.max(1, bounds.height - TAMY)));
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

    // Actualiza posición rebotando en bordes
    public void mueve_pelota(Rectangle2D limites) {
        x += dx;
        y += dy;

        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }
        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }
        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }
        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }
    }

    public void detener() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            mueve_pelota(lienzo.getBounds());
            lienzo.repaint();
            try {
                Thread.sleep(10 + rand.nextInt(20));
            } catch (InterruptedException ignored) {}
        }
    }
}

// ---------------------- Lienzo que dibuja pelotas ----------------------
class LaminaPelota extends JPanel {
    private final List<Pelota> pelotas = new ArrayList<>();

    public void add(Pelota b) {
        pelotas.add(b);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota b : pelotas) {
            g2.fill(b.getShape());
        }
    }

    public void detenerTodas() {
        // Detener hilos si se quiere, aquí no guardamos referencias a Threads.
    }
}

// ---------------------- Marco con botones ----------------------
class MarcoRebote extends JFrame {
    private final LaminaPelota lamina;

    public MarcoRebote() {
        setBounds(600, 300, 500, 400);
        setTitle("Rebotes");
        setLayout(new BorderLayout());

        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();
        ponerBoton(laminaBotones, "Agregar pelota!", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });
        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });

        add(laminaBotones, BorderLayout.SOUTH);
    }

    // Agrega una pelota y arranca su hilo
    public void comienza_el_juego() {
        Pelota pelota = new Pelota(lamina);
        lamina.add(pelota);
        Thread t = new Thread(pelota);
        t.start();
    }

    // Utilidad para crear botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }
}
