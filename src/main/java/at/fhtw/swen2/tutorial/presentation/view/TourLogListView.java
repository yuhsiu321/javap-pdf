package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourLogListViewModel;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
public class TourLogListView implements Initializable {

    @Autowired
    public TourLogListViewModel tourLogListViewModel;
    @Autowired
    public TourLogRepository tourLogRepository;
    @FXML
    public TableView tableView = new TableView<>();
    @FXML
    public VBox dataContainer;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        tableView.setItems(tourLogListViewModel.getTourLogListItems());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        TableColumn time = new TableColumn("Time");
        time.setCellValueFactory(new PropertyValueFactory("time"));
        TableColumn comment = new TableColumn("Comment");
        comment.setCellValueFactory(new PropertyValueFactory("comment"));

        tableView.getColumns().addAll(time);
        tableView.getColumns().addAll(comment);


        dataContainer.getChildren().add(tableView);
        tourLogListViewModel.initList();

        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                // Retrieve selected item
                TourLog selectedItem = (TourLog)tableView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    // Remove selected item from data source
                    tourLogListViewModel.deleteItem(selectedItem.getComment());
                    tourLogRepository.delete(tourLogRepository.findByComment(selectedItem.getComment()));
                }
            }
        });
    }


}
