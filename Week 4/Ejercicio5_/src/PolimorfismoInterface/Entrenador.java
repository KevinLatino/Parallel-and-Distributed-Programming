
package PolimorfismoInterface;

public class Entrenador extends SeleccionFutbol {
    private String idFederacion;

    public Entrenador(int id, String nombre, String apellido, int edad, String idFederacion) {
        super(id, nombre, apellido, edad);
        this.idFederacion = idFederacion;
    }

    public void planificarEntrenamiento() {
        System.out.println(titulo() + " planifica el microciclo (idFed: " + idFederacion + ").");
    }

    @Override
    public void entrenar() {
        System.out.println(titulo() + " dirige la sesión táctica.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(titulo() + " dirige el partido desde la zona técnica.");
    }
}
