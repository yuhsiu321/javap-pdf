package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTourViewModel {

    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel;
    private SimpleStringProperty deleteName = new SimpleStringProperty();


    public String getDeleteName() {
        return deleteName.get();
    }

    public SimpleStringProperty DeleteNameProperty() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName.set(deleteName);
    }

    public void delete() {
        Tour tour = tourService.findByName(getDeleteName());
        System.out.println(tour);
        tourListViewModel.deleteItem(tour);
        tourService.delete(getDeleteName());
        //System.out.println(tour);

    }
}
