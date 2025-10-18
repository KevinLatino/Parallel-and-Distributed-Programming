package Seleccion;

public class Entrenador extends SeleccionFutbol {
    private String idFederacion;

    public Entrenador(int id, String nombre, String apellido, int edad, String idFederacion) {
        super(id, nombre, apellido, edad);
        this.idFederacion = idFederacion;
    }

    public void planificarEntrenamiento() {
        System.out.println(getTitulo() + " planifica el entrenamiento (idFed: " + idFederacion + ").");
    }

    @Override
    public void entrenar() {
        System.out.println(getTitulo() + " dirige la sesión de entrenamiento.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(getTitulo() + " dirige tácticamente el partido desde la banda.");
    }
}
