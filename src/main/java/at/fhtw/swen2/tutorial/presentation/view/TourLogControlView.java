package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Scope("prototype")
@Slf4j
public class TourLogControlView implements Initializable {
    @FXML
    public Button deleteButton;
    @FXML
    public Button moreButton;
    @FXML
    private Button createButton;

    @Autowired
    private ViewManager viewManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createButton.setOnAction(event -> {
            try {
                handleNewTourLog();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        deleteButton.setOnAction(event -> {
            try {
                handleDelete();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        moreButton.setOnAction(event -> {
            try {
                handleUpdate();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void handleUpdate() throws IOException {
        Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/FindUpdateTourLog");
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void handleDelete() throws IOException {
        Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/DeleteTourLog");
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void handleNewTourLog() throws IOException {
        Parent parent = viewManager.load("at/fhtw/swen2/tutorial/presentation/view/CreateTourLog");
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
