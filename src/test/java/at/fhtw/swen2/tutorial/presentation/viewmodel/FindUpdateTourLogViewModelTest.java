package at.fhtw.swen2.tutorial.presentation.viewmodel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourLogViewModel;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FindUpdateTourLogViewModelTest {

    @Autowired
    private FindUpdateTourLogViewModel findUpdateTourLogViewModel;

    @MockBean
    private TourLogService tourLogService;

    @Test
    public void testFindUpdateLog() {
        // Mock the input value
        String findUpdateComment = "Update Comment";

        // Mock the TourLogService
        TourLog expectedTourLog = mock(TourLog.class);
        when(tourLogService.findByComment(findUpdateComment)).thenReturn(expectedTourLog);

        // Set the findUpdateComment property
        findUpdateTourLogViewModel.setFindUpdateComment(findUpdateComment);

        // Call the findUpdateLog method
        TourLog actualTourLog = findUpdateTourLogViewModel.findUpdateLog();

        // Verify that the TourLogService is called with the expected comment
        verify(tourLogService).findByComment(findUpdateComment);

        // Verify that the returned TourLog matches the expectedTourLog
        assertEquals(expectedTourLog, actualTourLog);
    }
}

