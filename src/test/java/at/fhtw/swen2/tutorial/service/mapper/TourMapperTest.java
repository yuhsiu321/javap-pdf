package at.fhtw.swen2.tutorial.service.mapper;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TourMapperTest {

    @Autowired
    private TourMapper tourMapper;

    @Test
    public void testFromEntity() {
        // Create a sample TourEntity
        TourEntity tourEntity = TourEntity.builder()
                .id(1L)
                .name("First")
                .tourDescription("1")
                .from("here")
                .to("there")
                .transportType("drive")
                .tourDistance(100.0)
                .estimatedTime(120)
                .build();

        // Map TourEntity to Tour using the TourMapper
        Tour tour = tourMapper.fromEntity(tourEntity);

        // Verify the mapped Tour object
        assertEquals(tourEntity.getId(), tour.getId());
        assertEquals(tourEntity.getName(), tour.getName());
        assertEquals(tourEntity.getTourDescription(), tour.getTourDescription());
        assertEquals(tourEntity.getFrom(), tour.getFrom());
        assertEquals(tourEntity.getTo(), tour.getTo());
        assertEquals(tourEntity.getTransportType(), tour.getTransportType());
        assertEquals(tourEntity.getTourDistance(), tour.getDistance());
        assertEquals(tourEntity.getEstimatedTime(), tour.getTime());
    }

    @Test
    public void testToEntity() {
        // Create a sample Tour object
        Tour tour = Tour.builder()
                .id(1L)
                .name("First")
                .tourDescription("1")
                .from("here")
                .to("there")
                .transportType("drive")
                .distance(100.0)
                .time(120)
                .build();

        // Map Tour to TourEntity using the TourMapper
        TourEntity tourEntity = tourMapper.toEntity(tour);

        // Verify the mapped TourEntity object
        assertEquals(tour.getId(), tourEntity.getId());
        assertEquals(tour.getName(), tourEntity.getName());
        assertEquals(tour.getTourDescription(), tourEntity.getTourDescription());
        assertEquals(tour.getFrom(), tourEntity.getFrom());
        assertEquals(tour.getTo(), tourEntity.getTo());
        assertEquals(tour.getTransportType(), tourEntity.getTransportType());
        assertEquals(tour.getDistance(), tourEntity.getTourDistance());
        assertEquals(tour.getTime(), tourEntity.getEstimatedTime());
    }
}

