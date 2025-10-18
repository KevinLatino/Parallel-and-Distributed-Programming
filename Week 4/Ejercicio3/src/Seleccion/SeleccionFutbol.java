package Seleccion;

/**
 * Clase base abstracta que representa a un integrante de la selección.
 * Contiene comportamiento común (concentrarse y viajar) y define métodos
 * que las subclases pueden sobreescribir (entrenar, jugarPartido).
 */
public abstract class SeleccionFutbol {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected int edad;

    public SeleccionFutbol(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void concentrarse() {
        System.out.println(getTitulo() + " se concentra con el equipo.");
    }

    public void viajar() {
        System.out.println(getTitulo() + " viaja con la selección.");
    }

    // Métodos que las subclases pueden redefinir
    public void entrenar() {
        System.out.println(getTitulo() + " entrena.");
    }

    public void jugarPartido() {
        System.out.println(getTitulo() + " participa en el partido.");
    }

    protected String getTitulo() {
        return this.getClass().getSimpleName() + " " + nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return getTitulo() + " (id=" + id + ", edad=" + edad + ")";
    }
}
