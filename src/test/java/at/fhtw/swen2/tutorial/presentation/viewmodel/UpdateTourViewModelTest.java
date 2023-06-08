package at.fhtw.swen2.tutorial.presentation.viewmodel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.FindUpdateTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.UpdateTourViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UpdateTourViewModelTest {

    @Autowired
    private UpdateTourViewModel updateTourViewModel;

    @Autowired
    private TourService tourService;

    @Mock
    private FindUpdateTourViewModel findUpdateTourViewModel;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        updateTourViewModel.setFindUpdateTourViewModel(findUpdateTourViewModel);
    }

    @Test
    public void testUpdate() {
        // Set up the initial tour and updated values
        Tour initialTour = Tour.builder()
                .name("Old Tour")
                .tourDescription("Old Description")
                .from("Old From")
                .to("Old To")
                .transportType("Old Transport")
                .build();

        tourService.addNew(initialTour);

        // Mock the findUpdate method to return the initialTour
        when(findUpdateTourViewModel.findUpdate()).thenReturn(initialTour);

        StringProperty updateName = new SimpleStringProperty("New Tour");
        StringProperty updateDes = new SimpleStringProperty("New Description");
        StringProperty updateFrom = new SimpleStringProperty("New From");
        StringProperty updateTo = new SimpleStringProperty("New To");
        ObjectProperty<String> updateTransportType = new SimpleObjectProperty<>("New Transport");

        // Update the tour
        updateTourViewModel.update(updateName, updateDes, updateTo, updateFrom, updateTransportType);

        // Verify the updated tour
        Tour updatedTour = findUpdateTourViewModel.findUpdate();
        assertEquals(updateName.get(), updatedTour.getName());
        assertEquals(updateDes.get(), updatedTour.getTourDescription());
        assertEquals(updateFrom.get(), updatedTour.getFrom());
        assertEquals(updateTo.get(), updatedTour.getTo());
        assertEquals(updateTransportType.get(), updatedTour.getTransportType());
    }

}




