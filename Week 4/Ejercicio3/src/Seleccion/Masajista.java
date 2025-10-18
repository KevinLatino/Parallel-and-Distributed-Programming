package Seleccion;

public class Masajista extends SeleccionFutbol {
    private String titulacion;
    private int aniosExperiencia;

    public Masajista(int id, String nombre, String apellido, int edad, String titulacion, int aniosExperiencia) {
        super(id, nombre, apellido, edad);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public void darMasaje() {
        System.out.println(getTitulo() + " realiza un masaje (tit: " + titulacion + ", exp: " + aniosExperiencia + " años).");
    }

    @Override
    public void entrenar() {
        System.out.println(getTitulo() + " asiste a los jugadores durante el entrenamiento.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(getTitulo() + " permanece atento para asistir a los jugadores en el partido.");
    }
}
