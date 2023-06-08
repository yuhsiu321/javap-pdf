package at.fhtw.swen2.tutorial.presentation.view;


import javafx.fxml.Initializable;
import javafx.scene.control.Dialog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class TourDataView extends Dialog<Void> implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}
