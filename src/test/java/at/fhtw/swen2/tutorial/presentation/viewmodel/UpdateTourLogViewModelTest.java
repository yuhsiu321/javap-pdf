package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourLogViewModel;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UpdateTourLogViewModelTest {

    @Autowired
    private UpdateTourLogViewModel updateTourLogViewModel;

    @MockBean
    private TourLogService tourLogService;

    @MockBean
    private FindUpdateTourLogViewModel findUpdateTourLogViewModel;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        updateTourLogViewModel.setFindUpdateTourLogViewModel(findUpdateTourLogViewModel);
    }

    @Test
    public void testUpdate() {
        // Set up the initial tour and updated values
        TourLog initialTourLog = TourLog.builder()
                .time("Old Time")
                .comment("Old Comment")
                .tourName("Old TourName")
                .rating("Old Rating")
                .difficulty("Old Difficult")
                .build();

        tourLogService.addnew(initialTourLog);

        // Mock the findUpdate method to return the initialTour
        when(findUpdateTourLogViewModel.findUpdateLog()).thenReturn(initialTourLog);

        StringProperty updateComment = new SimpleStringProperty("New Comment");
        StringProperty updateTime = new SimpleStringProperty("Old Time");
        StringProperty updateTourName = new SimpleStringProperty("Old TourName");
        ObjectProperty<String> updateRating = new SimpleObjectProperty<>("New Rating");
        ObjectProperty<String> updateDifficult = new SimpleObjectProperty<>("New Difficult");
        // Update the tour
        updateTourLogViewModel.update(updateComment,updateTourName,updateTime, updateRating, updateDifficult);

        // Verify the updated tour
        TourLog updatedTourLog = findUpdateTourLogViewModel.findUpdateLog();
        assertEquals(updateComment.get(), updatedTourLog.getComment());
        assertEquals(updateTime.get(), updatedTourLog.getTime());
        assertEquals(updateTourName.get(), updatedTourLog.getTourName());
        assertEquals(updateRating.get(), updatedTourLog.getRating());
        assertEquals(updateDifficult.get(), updatedTourLog.getDifficulty());

    }
}


