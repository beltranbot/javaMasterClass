package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    // variable has to have the same name that the id in the fxml
    @FXML
    private TextField nameField;

    @FXML
    public void onButtonClicked() {
        System.out.println("Hello, " + nameField.getText());
    }
}
