package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.presentation.viewmodel.DeleteTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DeleteTourViewModelTest {

    @MockBean
    private TourService tourService;

    @MockBean
    private TourListViewModel tourListViewModel;

    @Autowired
    private DeleteTourViewModel deleteTourViewModel;

    @Test
    public void testDelete() {
        // Set the necessary properties for the view model
        deleteTourViewModel.setDeleteName("First");

        // Mock the tour returned by tourService
        Tour expectedTour = Tour.builder()
                .name("First")
                .build();
        when(tourService.findByName("First")).thenReturn(expectedTour);

        // Call the method under test
        deleteTourViewModel.delete();

        // Verify that the tourListViewModel's deleteItem method was called with the expected tour
        verify(tourListViewModel).deleteItem(expectedTour);

        // Verify that the tourService's delete method was called with the expected tour name
        verify(tourService).delete("First");

        assertEquals("First", deleteTourViewModel.getDeleteName());

    }

}


