package at.fhtw.swen2.tutorial.service;

import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.springframework.stereotype.Component;

import java.util.List;

public interface TourService {

    List<Tour> getTourList();

    Tour addNew(Tour tour);

    void delete(String name);

    Tour findByName(String name);

    Tour updateTour(Tour tour);

    // erweitern mit parameter create new service

}
