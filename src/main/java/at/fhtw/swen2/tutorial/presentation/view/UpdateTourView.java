package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.DeleteTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.UpdateTourViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.impl.TourServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javafx.beans.property.*;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class UpdateTourView extends Dialog<Void> implements Initializable {
    @Autowired
    private UpdateTourViewModel updateTourViewModel;


    @Autowired
    private FindUpdateTourViewModel findUpdateTourViewModel;

    @Autowired
    private TourService tourService;

    @FXML
    public TextField nameTextField;

    @FXML
    private TextField desTextField;
    @FXML
    public ChoiceBox transportType;
    @FXML
    private TextField toTextField;
    @FXML
    private TextField fromTextField;

    @FXML
    public Button updateButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Tour tour = findUpdateTourViewModel.findUpdate();
        nameTextField.setText(tour.getName());
        desTextField.setText(tour.getTourDescription());
        fromTextField.setText(tour.getFrom());
        toTextField.setText(tour.getTo());
        transportType.setValue(tour.getTransportType());

        //nameTextField.textProperty().bindBidirectional(updateTourViewModel.UpdateNameProperty());
        //desTextField.textProperty().bindBidirectional(updateTourViewModel.tourDescriptionProperty());
        //fromTextField.textProperty().bindBidirectional(updateTourViewModel.fromProperty());
        //toTextField.textProperty().bindBidirectional(updateTourViewModel.toProperty());
        //transportType.valueProperty().bindBidirectional(updateTourViewModel.transportTypeProperty());

    }

    public void updateButtonAction() {
   
        StringProperty updateName = nameTextField.textProperty();
        StringProperty updateDes = desTextField.textProperty();
        StringProperty updateTo = toTextField.textProperty();
        StringProperty updateFrom = fromTextField.textProperty();
        ObjectProperty<String> updateTransportType = transportType.valueProperty();

        System.out.println(updateName);
        updateTourViewModel.update(updateName,updateDes,updateTo,updateFrom,updateTransportType);


    }
}
