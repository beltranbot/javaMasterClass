package sample;

import datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ContactController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField notesField;

    public Contact getNewContact() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String notes = notesField.getText();
        Contact contact = new Contact(
                firstName,
                lastName,
                phoneNumber,
                notes
        );
        return contact;
    }


}
