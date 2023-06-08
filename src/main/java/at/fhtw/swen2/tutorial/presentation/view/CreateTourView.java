package at.fhtw.swen2.tutorial.presentation.view;
import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.presentation.viewmodel.CreateTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class CreateTourView extends Dialog<Void> implements Initializable{

    @FXML
    public ChoiceBox transportType;
    @FXML
    private TextField toTextField;
    @FXML
    private TextField fromTextField;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField desTextField;
    @FXML
    private Button submitButton;

    @Autowired
    private CreateTourViewModel createTourViewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.textProperty().bindBidirectional(createTourViewModel.nameProperty());
        desTextField.textProperty().bindBidirectional(createTourViewModel.tourDescriptionProperty());
        fromTextField.textProperty().bindBidirectional(createTourViewModel.fromProperty());
        toTextField.textProperty().bindBidirectional(createTourViewModel.toProperty());
        transportType.valueProperty().bindBidirectional(createTourViewModel.transportTypeProperty());
    }

    public void submitButtonAction(ActionEvent event) throws IOException {
        System.out.println(transportType.getValue());
        createTourViewModel.addNewTour();
    }

}
