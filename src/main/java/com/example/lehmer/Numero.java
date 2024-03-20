package com.example.lehmer;

public class Numero {
    private int iteracion;
    private double pseudoNumero;

    public Numero(int iteracion, double pseudoNumero) {
        this.iteracion = iteracion;
        this.pseudoNumero = pseudoNumero;
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    public double getPseudoNumero() {
        return pseudoNumero;
    }

    public void setPseudoNumero(double pseudoNumero) {
        this.pseudoNumero = pseudoNumero;
    }
}
