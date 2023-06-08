package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.CreateTourLogViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.CreateTourViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class CreateTourLogView extends Dialog<Void> implements Initializable {
    @FXML
    public TextField commentTextField;
    @FXML
    public TextField tourNameTextField;
    @FXML
    public ChoiceBox ratingBox;
    @FXML
    public ChoiceBox difficultBox;
    public TextField timeTextField;

    @Autowired
    private CreateTourLogViewModel createTourLogViewModel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        commentTextField.textProperty().bindBidirectional(createTourLogViewModel.commentProperty());
        tourNameTextField.textProperty().bindBidirectional(createTourLogViewModel.tourNameProperty());
        ratingBox.valueProperty().bindBidirectional(createTourLogViewModel.ratingProperty());
        difficultBox.valueProperty().bindBidirectional(createTourLogViewModel.difficultyProperty());
        timeTextField.textProperty().bindBidirectional(createTourLogViewModel.totalTimeProperty());
    }
    public void submitButtonAction(ActionEvent event) throws IOException {
       createTourLogViewModel.addNewTourLog();
    }

}
