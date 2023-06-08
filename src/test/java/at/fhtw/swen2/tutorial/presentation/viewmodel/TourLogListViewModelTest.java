package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourLogListViewModel;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TourLogListViewModelTest {

    @Autowired
    private TourLogListViewModel tourLogListViewModel;

    @Autowired
    private TourLogService tourLogService;

    @Test
    public void testInitList() {
        // Clear existing items
        tourLogListViewModel.clearItems();

        // Initialize the list
        tourLogListViewModel.initList();

        // Verify the list has been populated
        ObservableList<TourLog> tourLogListItems = tourLogListViewModel.getTourLogListItems();
        assertEquals(tourLogService.getTourLogList().size(), tourLogListItems.size());
    }

    @Test
    public void testFilterList() {
        // Clear existing items
        tourLogListViewModel.clearItems();

        // Add test data
        TourEntity tour1 = TourEntity.builder()
                .name("First")
                .build();


        TourEntity tour2 = TourEntity.builder()
                .name("Second")
                .build();

        TourLog tourLog1 = TourLog.builder()
                .comment("Comment 1")
                .tourEntity(tour1)
                .build();
        tourLog1.setComment("Comment 1");
        tourLog1.setTourEntity(tour1);

        TourLog tourLog2 = TourLog.builder()
                .comment("Comment 2")
                .tourEntity(tour2)
                .build();


        tourLogListViewModel.addItem(tourLog1);
        tourLogListViewModel.addItem(tourLog2);

        // Filter the list
        String searchText = "First";
        tourLogListViewModel.filterList(searchText);

        // Verify the filtered list
        ObservableList<TourLog> filteredList = tourLogListViewModel.getTourLogListItems();
        assertEquals(2, filteredList.size());
        assertTrue(filteredList.get(0).getTourEntity().getName().toLowerCase().contains(searchText.toLowerCase()));
    }

}
