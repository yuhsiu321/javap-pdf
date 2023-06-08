package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.presentation.viewmodel.SearchViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourLogListViewModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class SearchViewModelTest {

    @MockBean
    private TourListViewModel tourListViewModel;

    @MockBean
    private TourLogListViewModel tourLogListViewModel;

    @Autowired
    private SearchViewModel searchViewModel;

    @Test
    public void testSearch() {
        // Set the search string
        searchViewModel.setSearchString("Test");

        // Call the method under test
        searchViewModel.search();

        // Verify that the filterList method was called on the tourListViewModel with the search string
        verify(tourListViewModel).filterList("Test");

        // Verify that the filterList method was called on the tourLogListViewModel with the search string
        verify(tourLogListViewModel).filterList("Test");
    }
}

