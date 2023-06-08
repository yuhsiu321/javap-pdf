package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FindUpdateTourViewModelTest {

    @MockBean
    private TourService tourService;

    @Autowired
    private FindUpdateTourViewModel findUpdateTourViewModel;

    @Test
    public void testFindUpdate() {
        // Set the input value for findUpdateName
        String findUpdateName = "Second";
        findUpdateTourViewModel.setFindUpdateName(findUpdateName);

        // Create the expected tour object using the builder pattern
        Tour expectedTour = Tour.builder()
                .name("Second")
                .build();

        // Stub the findByName() method of the tourService to return the expectedTour
        when(tourService.findByName(findUpdateName)).thenReturn(expectedTour);

        // Invoke the findUpdate() method
        Tour actualTour = findUpdateTourViewModel.findUpdate();

        // Verify that the tourService's findByName method was called with the expected name
        verify(tourService).findByName(findUpdateName);

        // Verify the result
        assertEquals(expectedTour.getName(), actualTour.getName());
    }
}




