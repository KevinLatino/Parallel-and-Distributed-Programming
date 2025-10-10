package solucionesejercicio4;

import java.io.File;
import javax.swing.JTextArea;

class HiloBusqueda extends Thread {
    String directorio;
    JTextArea ta;

    public HiloBusqueda(String directorio, JTextArea ta) {
        this.directorio = directorio;
        this.ta = ta;
    }

    @Override
    public void run() {
        leer(directorio);
    }

    private void leer(String inicio) {
        File ar = new File(inicio);
        String[] dir = ar.list();
        if (dir != null) {
            for (int f = 0; f < dir.length; f++) {
                File ar2 = new File(inicio + dir[f]);
                if (ar2.isFile())
                    ta.append(inicio + dir[f] + "\n");
                if (ar2.isDirectory()) {
                    ta.append(inicio + dir[f].toUpperCase() + " --> [Directorio]\n");
                    leer(inicio + dir[f] + "\\");
                }
            }
        }
    }
}
