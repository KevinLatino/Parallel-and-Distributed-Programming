
package PolimorfismoInterface;

public class Masajista extends SeleccionFutbol {
    private String titulacion;
    private int aniosExperiencia;

    public Masajista(int id, String nombre, String apellido, int edad, String titulacion, int aniosExperiencia) {
        super(id, nombre, apellido, edad);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public void darMasaje() {
        System.out.println(titulo() + " aplica un masaje de recuperación (tit: " + titulacion + ", exp: " + aniosExperiencia + " años).");
    }

    @Override
    public void entrenar() {
        System.out.println(titulo() + " asiste con fisioterapia durante el entrenamiento.");
    }

    @Override
    public void jugarPartido() {
        System.out.println(titulo() + " está preparado para asistir a los jugadores en el partido.");
    }
}
