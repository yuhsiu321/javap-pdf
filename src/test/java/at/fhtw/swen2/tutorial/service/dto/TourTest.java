package at.fhtw.swen2.tutorial.service.dto;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TourTest {

    @Test
    public void testTourBuilder() {
        Long id = 1L;
        String name = "First";
        String tourDescription = "1";
        String from = "here";
        String to = "there";
        String transportType = "drive";
        Double distance = 100.0;
        Integer time = 120;

        Tour tour = Tour.builder()
                .id(id)
                .name(name)
                .tourDescription(tourDescription)
                .from(from)
                .to(to)
                .transportType(transportType)
                .distance(distance)
                .time(time)
                .build();

        assertNotNull(tour);
        assertEquals(id, tour.getId());
        assertEquals(name, tour.getName());
        assertEquals(tourDescription, tour.getTourDescription());
        assertEquals(from, tour.getFrom());
        assertEquals(to, tour.getTo());
        assertEquals(transportType, tour.getTransportType());
        assertEquals(distance, tour.getDistance());
        assertEquals(time, tour.getTime());
    }
}

