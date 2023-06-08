package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.presentation.viewmodel.CreateTourViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CreateTourViewModelTest {

    @MockBean
    private TourService tourService;

    @Autowired
    private CreateTourViewModel createTourViewModel;

    @Test
    public void testAddNewTour() throws IOException {
        // Mock the required dependencies
        Tour expectedTour = Tour.builder()
                .name("First")
                .tourDescription("1")
                .from("Here")
                .to("There")
                .transportType("")
                .distance(100.0)
                .time(60)
                .build();
        when(tourService.addNew(any(Tour.class))).thenReturn(expectedTour);

        // Set the necessary properties for the view model
        createTourViewModel.setName("First");
        createTourViewModel.setTourDescription("1");
        createTourViewModel.setFrom("Here");
        createTourViewModel.setTo("There");
        createTourViewModel.setTransportType("");
        createTourViewModel.setDistance(100.0);
        createTourViewModel.setTime(60);

        // Call the method under test
        createTourViewModel.addNewTour();

        // Verify that the tourService's addNew method was called with the expected tour
        verify(tourService).addNew(argThat(tour ->
                tour.getName().equals("First") &&
                        tour.getTourDescription().equals("1") &&
                        tour.getFrom().equals("Here") &&
                        tour.getTo().equals("There") &&
                        tour.getTransportType().equals("")
        ));

    }

}

