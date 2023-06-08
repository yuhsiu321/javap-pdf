package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
public class TourListView implements Initializable{

    @Autowired
    public TourListViewModel tourListViewModel;

    @Autowired
    public TourRepository tourRepository;

    @FXML
    public TableView tableView = new TableView<>();
    @FXML
    public VBox dataContainer;


    @Override
    public void initialize(URL location, ResourceBundle rb){
        tableView.setItems(tourListViewModel.getTourListItems());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        TableColumn name = new TableColumn("Tour List");
        name.setCellValueFactory(new PropertyValueFactory("name"));

        tableView.getColumns().addAll(name);

        dataContainer.getChildren().add(tableView);
        tourListViewModel.initList();

        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                // Retrieve selected item
                Tour selectedItem = (Tour)tableView.getSelectionModel().getSelectedItem();
                if(selectedItem!=null){
                    tourListViewModel.showDetailsWindow(selectedItem);
                }
            }
        });
    }


}
