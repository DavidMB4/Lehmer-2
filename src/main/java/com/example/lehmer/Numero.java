package com.example.lehmer;

import java.security.PrivateKey;

public class Numero {
    private int iteracion;
    private double pseudoNumero;
    private long YCol;
    private long Extrac;
    private long ZCol;

    public Numero(int iteracion, double pseudoNumero, long YCol, long Extrac, long ZCol) {
        this.iteracion = iteracion;
        this.pseudoNumero = pseudoNumero;
        this.YCol = YCol;
        this.Extrac = Extrac;
        this.ZCol = ZCol;
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
    public long getYCol() {
        return YCol;
    }
    public void setY(long YCol) {
        this.YCol = YCol;
    }

    public long getExtrac() {
        return Extrac;
    }
    public void setExtrac(long Extrac) {
        this.Extrac = Extrac;
    }

    public long getZCol() {
        return ZCol;
    }

    public void setZCol(long Z) {
        this.ZCol = ZCol;
    }
}
