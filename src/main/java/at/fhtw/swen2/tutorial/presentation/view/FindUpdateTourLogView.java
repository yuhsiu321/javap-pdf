package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.ViewManager;
import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourLogViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
public class FindUpdateTourLogView extends Dialog<Void> implements Initializable {

    @Autowired
    private FindUpdateTourLogViewModel findUpdateTourLogViewModel;

    @FXML
    public TextField commentTextField;


    @FXML
    public Button findUpdateLogButton;


    @Autowired
    private ViewManager viewManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        commentTextField.textProperty().bindBidirectional(findUpdateTourLogViewModel.FindUpdateCommentProperty());
    }

    public void findUpdateLogButtonAction() throws IOException {

        if (findUpdateTourLogViewModel.findUpdateLog() != null) {
            Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/UpdateTourLog");
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        }
    }
}
