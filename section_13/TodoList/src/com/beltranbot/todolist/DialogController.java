package com.beltranbot.todolist;

import com.beltranbot.todolist.datamodel.TodoData;
import com.beltranbot.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    @FXML
    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem todoItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(todoItem);
        return todoItem;
    }

}
