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
    @FXML private TableColumn<Numero , Double> pseudoCol;

    private long ExtracLong;
    private double m;
    private long A;
    private int num;
    private long z;
    private long Ylong;

    public Lehmer(long Xo, long A, long ExtracLong, double m, int num, long z, long Ylong) {
        this.Xo = Xo;
        this.A = A;
        this.ExtracLong = ExtracLong;
        this.m = m;
        this.num = num;
        this.z = z;
        this.Ylong = Ylong;
    }

    public double next() {
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

        Xo = (Ylong - ExtracLong);
        return (double) Xo / m;
    }

    public void initialize(){
        iteracionCol.setCellValueFactory(new PropertyValueFactory<Numero, Integer>("iteracion"));
        pseudoCol.setCellValueFactory(new PropertyValueFactory<Numero, Double>("pseudoNumero"));

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
        long Xo = Long.parseLong(XoText.getText());

        long A = Long.parseLong(AText.getText());

        int num = Integer.parseInt(numText.getText());

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

        Lehmer rng = new Lehmer(Xo, A, ExtracLong, m, num, z, Ylong);

        // Generar y mostrar algunos números pseudoaleatorios
        for (int i = 1; i <= num; i++) {

            Numero numero = new Numero (i, rng.next());
            this.table.getItems().add(numero);
        }

    }
}
