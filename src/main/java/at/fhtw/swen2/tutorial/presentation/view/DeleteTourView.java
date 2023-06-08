package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.DeleteTourViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
@Component
@Scope("prototype")
@Slf4j
public class DeleteTourView extends Dialog<Void> implements Initializable {

    @Autowired
    private DeleteTourViewModel deleteTourViewModel;

    @FXML
    public TextField nameTextField;
    @FXML
    public Button deleteButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.textProperty().bindBidirectional(deleteTourViewModel.DeleteNameProperty());
    }

    public void deleteButtonAction() {
        deleteTourViewModel.delete();

    }
}
