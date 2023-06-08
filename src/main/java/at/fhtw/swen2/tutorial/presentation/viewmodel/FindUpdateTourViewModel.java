package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUpdateTourViewModel {
    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel;
    private SimpleStringProperty findUpdateName = new SimpleStringProperty();


    public String getFindUpdateName() {
        return findUpdateName.get();
    }

    public SimpleStringProperty FindUpdateNameProperty() {
        return findUpdateName;
    }

    public void setFindUpdateName(String findUpdateName) {
        this.findUpdateName.set(findUpdateName);
    }

    public Tour findUpdate() {
        Tour tour = tourService.findByName(getFindUpdateName());

        System.out.println(tour);

        return tour;

        //show tour detail

    }

}
