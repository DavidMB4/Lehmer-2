module com.example.lehmer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.lehmer to javafx.fxml;
    exports com.example.lehmer;
}