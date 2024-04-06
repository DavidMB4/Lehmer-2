package com.example.lehmer;

import java.util.Scanner;
import java.util.function.UnaryOperator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Lehmer {
    private Scanner scanner;
    public Lehmer(){


    }
    private long Xo;
    @FXML private TextField XoText;
    @FXML private TextField AText;
    @FXML private TextField numText;
    @FXML private Button Aceptar;

    @FXML private TableView<Numero> table;
    @FXML private TableColumn<Numero , Integer> iteracionCol;
    @FXML private TableColumn<Numero , Long> YCol;
    @FXML private TableColumn<Numero , Long> Extrac;
    @FXML private TableColumn<Numero , Double> pseudoCol;
    @FXML private TableColumn<Numero , Long> ZCol;

    private long ExtracLong;
    private double m;
    private long A;
    private int num;
    private long z;
    private long z2;
    private long Ylong;

    public Lehmer(long Xo, long A, long ExtracLong, double m, int num, long z, long z2, long Ylong) {
        this.Xo = Xo;
        this.A = A;
        this.ExtracLong = ExtracLong;
        this.m = m;
        this.num = num;
        this.z = z;
        this.z2 = z2;
        this.Ylong = Ylong;

    }

    public double next() {
        String mString = Long.toString(Xo);
        int largo = mString.length();

        double m = Math.pow(10, largo);
        z = A*Xo;
        String ZString = Long.toString(z);
        int ZLong = ZString.length();

        String parteExtraida = ZString.substring(0, ZLong-largo);
        ExtracLong = Long.parseLong(parteExtraida);

        int diferencia = ZString.length() - largo;
        String YString = ZString.substring(diferencia, ZLong);
        Ylong = Long.parseLong(YString);

        Xo = (Ylong - ExtracLong);
        z2=A*Xo;
        return (double) Xo / m;
    }

    public void initialize(){
        iteracionCol.setCellValueFactory(new PropertyValueFactory<Numero, Integer>("iteracion"));
        YCol.setCellValueFactory(new PropertyValueFactory<Numero, Long>("YCol"));
        Extrac.setCellValueFactory(new PropertyValueFactory<Numero, Long>("Extrac"));
        pseudoCol.setCellValueFactory(new PropertyValueFactory<Numero, Double>("pseudoNumero"));
        ZCol.setCellValueFactory(new PropertyValueFactory<Numero, Long>("ZCol"));

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        XoText.setTextFormatter(new TextFormatter<>(filter));
        AText.setTextFormatter(new TextFormatter<>(filter));
        numText.setTextFormatter(new TextFormatter<>(filter));
    }


    public void Aceptar(){
        this.table.getItems().clear();

        long Xo = DatoXo();

        long A = DatoA();

        int num = DatoNum();

        String mString = Long.toString(Xo);
        int largo = mString.length();

        double m = Math.pow(10, largo);
        long z = A*Xo;
        String ZString = Long.toString(z);
        int ZLong = ZString.length();

        String parteExtraida = ZString.substring(0, ZLong-largo);
        Long ExtracLong = Long.parseLong(parteExtraida);

        int diferencia = ZString.length() - largo;
        String YString = ZString.substring(diferencia, ZLong);
        Long Ylong = Long.parseLong(YString);

        Lehmer rng = new Lehmer(Xo, A, 0, 0, num, 0, 0,0);

        // Generar y mostrar algunos números pseudoaleatorios
        for (int i = 1; i <= num; i++) {

            Numero numero = new Numero (i, rng.next(), rng.getYlong(), rng.getExtracLong(), rng.getZ2());
            this.table.getItems().add(numero);
        }

    }

    public long DatoXo(){
        if(XoText.getText() != ""){
            long Dato1 = Long.parseLong(XoText.getText());
            return Dato1;
        } else {
            throw new IllegalArgumentException("Faltan datos en Xo.");
        }
    }

    public long DatoA(){
        if(AText.getText() != ""){
            long Dato2 = Long.parseLong(AText.getText());
            return Dato2;
        } else {
            throw new IllegalArgumentException("Faltan datos en A.");
        }
    }

    public int DatoNum(){
        if(numText.getText() != ""){
            int Dato3 = Integer.parseInt(numText.getText());
            return Dato3;
        } else {
            throw new IllegalArgumentException("Faltan datos en Numero de iteraciones.");
        }
    }
    public long getYlong() {
        return Ylong;
    }

    public long getExtracLong() {
        return ExtracLong;
    }

    public long getZ2() {
        return z2;
    }
}
