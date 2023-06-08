package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.presentation.viewmodel.CreateTourLogViewModel;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CreateTourLogViewModelTest {

    @MockBean
    private TourLogService tourLogService;

    @MockBean
    private TourRepository tourRepository;

    @Autowired
    private CreateTourLogViewModel createTourLogViewModel;

    @Test
    public void testAddNewTourLog() throws IOException {
        // Mock the required dependencies
        TourEntity expectedTourEntity = new TourEntity();
        when(tourRepository.findByName(anyString())).thenReturn(expectedTourEntity);

        // Set the necessary properties for the view model
        createTourLogViewModel.setTourName("First");
        createTourLogViewModel.setComment("1234246");
        createTourLogViewModel.setDifficulty("2");
        createTourLogViewModel.setRating("5");
        createTourLogViewModel.setTotalTime("1 hour");

        // Call the method under test
        createTourLogViewModel.addNewTourLog();

        // Verify that the tourLogService's addNew method was called with the expected tour log
        verify(tourLogService).addnew(argThat(tourLog ->
                tourLog.getComment().equals("1234246") &&
                        tourLog.getDifficulty().equals("2") &&
                        tourLog.getRating().equals("5") &&
                        tourLog.getTotalTime().equals("1 hour") &&
                        tourLog.getTourEntity() == expectedTourEntity
        ));

    }

}

