module JavaFxChalenge {

    requires javafx.fxml;
    requires javafx.controls;
    requires java.xml;

    opens sample;
    exports datamodel;
}