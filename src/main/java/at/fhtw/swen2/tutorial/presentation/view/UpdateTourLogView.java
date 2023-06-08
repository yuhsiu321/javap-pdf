package at.fhtw.swen2.tutorial.presentation.view;


import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourLogViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.UpdateTourLogViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.UpdateTourViewModel;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
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

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class UpdateTourLogView extends Dialog<Void> implements Initializable {
    @Autowired
    private UpdateTourLogViewModel updateTourLogViewModel;

    @Autowired
    private FindUpdateTourLogViewModel findUpdateTourLogViewModel;

    @Autowired
    private TourLogService tourLogService;

    @FXML
    public TextField commentTextField;
    @FXML
    public TextField tourNameTextField;
    @FXML
    public ChoiceBox ratingBox;
    @FXML
    public ChoiceBox difficultBox;
    public TextField timeTextField;

    @FXML
    public Button updateLogButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TourLog tourLog = findUpdateTourLogViewModel.findUpdateLog();
        String tourName = tourLog.getTourEntity().getName();
        commentTextField.setText(tourLog.getComment());
        tourNameTextField.setText(tourName);
        timeTextField.setText(tourLog.getTotalTime());
        ratingBox.setValue(tourLog.getRating());
        difficultBox.setValue(tourLog.getDifficulty());

    }

    public void updateLogButtonAction(){

        StringProperty updateComment = commentTextField.textProperty();
        StringProperty updateTourName = tourNameTextField.textProperty();
        StringProperty updateTime = timeTextField.textProperty();
        ObjectProperty<String> updateRating = ratingBox.valueProperty();
        ObjectProperty<String> updateDifficult = difficultBox.valueProperty();

        updateTourLogViewModel.update(updateComment,updateTourName,updateTime,updateRating,updateDifficult);
    }
}
