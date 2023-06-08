package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NewTourViewModel {
    private SimpleLongProperty id = new SimpleLongProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty tourDescription = new SimpleStringProperty();
    private SimpleStringProperty from = new SimpleStringProperty();
    private SimpleStringProperty to = new SimpleStringProperty();

    private String apiKey = "vpYWl32FtXtF2BrrnpC5V94yYIqFkodG";

    private String baseUrl = "https://www.mapquestapi.com/directions/v2/route?key=" + apiKey;

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

    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel;

    public String getTourDescription() {
        return tourDescription.get();
    }

    public SimpleStringProperty tourDescriptionProperty() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription.set(tourDescription);
    }

    private Tour tour;


    public NewTourViewModel() {

    }

    public NewTourViewModel(Tour tour) {
        this.tour = tour;
        this.id = new SimpleLongProperty(tour.getId());
        this.name = new SimpleStringProperty(tour.getName());
        this.tourDescription = new SimpleStringProperty(tour.getTourDescription());
        this.from = new SimpleStringProperty(tour.getFrom());
        this.to = new SimpleStringProperty(tour.getTo());
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public void addNewPerson() {
        Tour tour = Tour.builder().name(getName()).tourDescription(getTourDescription()).from(getFrom()).to(getTo()).build();
        tour = tourService.addNew(tour);
        tourListViewModel.addItem(tour);
        System.out.println(tour);
    }


}
