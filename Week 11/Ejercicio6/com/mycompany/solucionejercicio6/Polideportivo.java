
package com.mycompany.solucionejercicio6;

public class Polideportivo implements InstalacionDeportiva, Edificio {
    private String nombre;
    private double superficie;
    private int tipoInstalacion;

    public Polideportivo(String nombre, double superficie, int tipoInstalacion){
        this.nombre=nombre;
        this.superficie=superficie;
        this.tipoInstalacion=tipoInstalacion;
    }

    @Override
    public int getTipoDeInstalacion(){
        return tipoInstalacion;
    }

    @Override
    public double getSuperficieEdificio(){
        return superficie;
    }

    @Override
    public String toString(){
        return "Polideportivo[nombre="+nombre+", superficie="+superficie+", tipo="+tipoInstalacion+"]";
    }
}
