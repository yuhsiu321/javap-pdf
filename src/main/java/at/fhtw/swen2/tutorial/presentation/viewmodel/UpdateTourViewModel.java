package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UpdateTourViewModel {

    @Autowired
    private TourService tourService;

    @Autowired
    private FindUpdateTourViewModel findUpdateTourViewModel;
    private SimpleStringProperty updateName = new SimpleStringProperty();

    private SimpleStringProperty tourDescription = new SimpleStringProperty();


    public String getTourDescription() {
        return tourDescription.get();
    }

    public SimpleStringProperty tourDescriptionProperty() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription.set(tourDescription);
    }

    public String getFrom() {
        return from.get();
    }

    public SimpleStringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public SimpleStringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public String getTransportType() {
        return transportType.get();
    }

    public ObjectProperty<String> transportTypeProperty() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType.set(transportType);
    }

    private SimpleStringProperty from = new SimpleStringProperty();

    private SimpleStringProperty to = new SimpleStringProperty();

    private ObjectProperty<String> transportType = new SimpleObjectProperty<>();

    public String getUpdateName() {
        return updateName.get();
    }

    public SimpleStringProperty UpdateNameProperty() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName.set(updateName);
    }


    public void update(StringProperty updateName,StringProperty updateDes,StringProperty updateTo,StringProperty updateFrom,ObjectProperty<String> updateTransportType) {

        //update tour detail
        Tour tour = Tour.builder().name(updateName.getValue()).tourDescription(updateDes.getValue()).from(updateFrom.getValue()).to(updateTo.getValue()).transportType(updateTransportType.getValue()).build();
        Tour oldTour = findUpdateTourViewModel.findUpdate();
        oldTour.setName(tour.getName());
        oldTour.setTourDescription(tour.getTourDescription());
        oldTour.setFrom(tour.getFrom());
        oldTour.setTo(tour.getTo());
        oldTour.setTransportType(tour.getTransportType());
        Tour newTour = tourService.updateTour(oldTour);
        System.out.println(newTour);


    }

    public void setFindUpdateTourViewModel(FindUpdateTourViewModel findUpdateTourViewModel) {
        this.findUpdateTourViewModel = findUpdateTourViewModel;
    }
}
