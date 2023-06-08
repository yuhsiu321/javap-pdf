package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TourListViewModelTest {

    @Mock
    private TourService tourService;

    @Autowired
    private TourListViewModel tourListViewModel;

    private ObservableList<Tour> tourListItems;

    @BeforeEach
    public void setup() {
        tourListItems = FXCollections.observableArrayList();
        tourListViewModel.setTourListItems(tourListItems);
    }

    @Test
    public void testInitList() {
        // Prepare data
        Tour tourList = Tour.builder()
                        .name("First")
                        .tourDescription("1")
                        .from("here")
                        .to("there")
                        .build();


        tourListItems.addAll(tourList);

        // Call the method under test
        tourListViewModel.filterList("First");

        // Verify that the tourListItems is updated with the tourList
        assertEquals(tourList, tourListItems.get(0));
    }

    @Test
    public void testFilterList() {
        // Prepare data
        List<Tour> tourList = Arrays.asList(
                Tour.builder()
                        .name("First")
                        .tourDescription("1")
                        .from("Here")
                        .to("There")
                        .transportType("")
                        .distance(80.0)
                        .time(60)
                        .build());

                Tour.builder()
                        .name("Second")
                        .tourDescription("2")
                        .from("Here")
                        .to("There")
                        .transportType("")
                        .distance(100.0)
                        .time(120)
                        .build();



        tourListItems.addAll(tourList);

        // Call the method under test
        tourListViewModel.filterList("First");

        // Verify that the tourListItems is filtered correctly
        assertEquals(1, tourListItems.size());
        assertEquals(tourList.get(0), tourListItems.get(0));
    }


}

