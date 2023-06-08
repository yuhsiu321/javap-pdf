package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.DeleteTourLogViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.DeleteTourViewModel;
import at.fhtw.swen2.tutorial.service.TourLogService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class DeleteTourLogView extends Dialog<Void> implements Initializable {
    @Autowired
    private DeleteTourLogViewModel deleteTourLogViewModel;

    @Autowired
    private TourLogService tourLogService;
    @FXML
    public TextField nameTextField;
    @FXML
    public Button deleteButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.textProperty().bindBidirectional(deleteTourLogViewModel.deleteCommentProperty());

    }

    public void deleteButtonAction(ActionEvent event) {
        deleteTourLogViewModel.delete();
    }
}
