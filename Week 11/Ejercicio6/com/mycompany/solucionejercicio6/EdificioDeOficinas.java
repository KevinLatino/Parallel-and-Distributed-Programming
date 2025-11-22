
package com.mycompany.solucionejercicio6;

public class EdificioDeOficinas implements Edificio {
    private double superficie;
    private int numOficinas;

    public EdificioDeOficinas(double superficie, int numOficinas){
        this.superficie=superficie;
        this.numOficinas=numOficinas;
    }

    @Override
    public double getSuperficieEdificio(){
        return superficie;
    }

    public int getNumOficinas(){
        return numOficinas;
    }

    @Override
    public String toString(){
        return "EdificioDeOficinas[sup="+superficie+", oficinas="+numOficinas+"]";
    }
}
