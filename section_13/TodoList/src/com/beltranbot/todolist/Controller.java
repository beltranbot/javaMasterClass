package com.beltranbot.todolist;

import com.beltranbot.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadLineLabel;

    @FXML
    private void initialize() {
        TodoItem item1 = new TodoItem(
                "Mail birthday card",
                "Buy a 30th birthday card for john",
                LocalDate.of(2020, Month.JUNE, 25)
        );
        TodoItem item2 = new TodoItem(
                "Doctor's appointment",
                "See Dr. Smith at 123 Main Street. Bring paperwork.",
                LocalDate.of(2020, Month.JULY, 23)
        );
        TodoItem item3 = new TodoItem(
                "Finish design proposal for client",
                "I promised Mike I'd email website mockups by friday 22nd April",
                LocalDate.of(2020, Month.APRIL, 22)
        );
        TodoItem item4 = new TodoItem(
                "Pickup Doug at the train station",
                "Doug's arriving on March 23 on the 5:00 train",
                LocalDate.of(2020, Month.MARCH, 23)
        );
        TodoItem item5 = new TodoItem(
                "Pick up dry cleaning",
                "The clothes should be ready by Wednesday",
                LocalDate.of(2020, Month.MAY, 31)
        );

        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    deadLineLabel.setText(item.getDeadline().toString());
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

//    @FXML
//    public void handleClickListView() {
//        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        itemDetailsTextArea.setText(item.getDetails());
//        deadLineLabel.setText(item.getDeadline().toString());
//    }
}
