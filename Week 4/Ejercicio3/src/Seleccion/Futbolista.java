package Seleccion;

public class Futbolista extends SeleccionFutbol {
    private int dorsal;
    private String posicion;

    public Futbolista(int id, String nombre, String apellido, int edad, int dorsal, String posicion) {
        super(id, nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public void entrevista() {
        System.out.println(getTitulo() + " da una entrevista.");
    }

    @Override
    public void entrenar() {
        System.out.println(getTitulo() + " realiza ejercicios específicos de " + posicion + ".");
    }

    @Override
    public void jugarPartido() {
        System.out.println(getTitulo() + " juega el partido con el dorsal " + dorsal + ".");
    }
}
