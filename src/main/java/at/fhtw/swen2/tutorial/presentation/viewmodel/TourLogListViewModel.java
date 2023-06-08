package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.presentation.view.TourLogListView;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TourLogListViewModel {

    @Autowired
    TourLogService tourLogService;

    private List<TourLog> masterData = new ArrayList<>();
    private ObservableList<TourLog> tourLogListItems = FXCollections.observableArrayList();

    public ObservableList<TourLog> getTourLogListItems() {
        return tourLogListItems;
    }

    public void addItem(TourLog tourLog) {
        tourLogListItems.add(tourLog);
        masterData.add(tourLog);
    }

    public void updateItem(String comment){

    }

    /*public void deleteItem(TourLog tourLog){
        tourLogListItems.remove(tourLog);
        masterData.remove(tourLog);
    }*/
    public void deleteItem(String comment) {
        TourLog tourLog = tourLogListItems.stream()
                .filter(log -> log.getComment().equals(comment))
                .findFirst()
                .orElse(null);

        if (tourLog != null) {
            tourLogListItems.remove(tourLog);
            masterData.remove(tourLog);
        }
    }


    public void clearItems(){ tourLogListItems.clear(); }

    public void initList(){
        tourLogService.getTourLogList().forEach(p -> {
            addItem(p);
        });
    }

    public void filterList(String searchText){
        Task<List<TourLog>> task = new Task<>() {
            @Override
            protected List<TourLog> call() throws Exception {
                updateMessage("Loading data");
                return masterData
                        .stream()
                        .filter(value -> value.getTourEntity().getName().toLowerCase().contains(searchText.toLowerCase()))
                        .collect(Collectors.toList());
            }
        };

        task.setOnSucceeded(event -> {
            tourLogListItems.setAll(task.getValue());
        });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

    }


}
