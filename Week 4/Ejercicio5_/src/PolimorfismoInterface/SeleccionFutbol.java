
package PolimorfismoInterface;

public abstract class SeleccionFutbol implements IntegranteSeleccion {
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

    protected String titulo() {
        return this.getClass().getSimpleName() + " " + nombre + " " + apellido;
    }

    @Override
    public void concentrarse() {
        System.out.println(titulo() + " se concentra con la selección.");
    }

    @Override
    public void viajar() {
        System.out.println(titulo() + " viaja con la selección.");
    }

    @Override
    public void entrenar() {
        System.out.println(titulo() + " realiza el entrenamiento estándar.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(titulo() + " participa en el partido.");
    }

    @Override
    public String toString() {
        return titulo() + " (id=" + id + ", edad=" + edad + ")";
    }
}
