
package PolimorfismoInterface;

public class Futbolista extends SeleccionFutbol {
    private int dorsal;
    private String posicion;

    public Futbolista(int id, String nombre, String apellido, int edad, int dorsal, String posicion) {
        super(id, nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public void entrevista() {
        System.out.println(titulo() + " concede una entrevista.");
    }

    @Override
    public void entrenar() {
        System.out.println(titulo() + " entrena específico de " + posicion + ".");
    }

    @Override
    public void jugarPartido() {
        System.out.println(titulo() + " salta al campo con el dorsal " + dorsal + ".");
    }
}
