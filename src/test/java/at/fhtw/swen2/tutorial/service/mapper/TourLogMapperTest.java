package at.fhtw.swen2.tutorial.service.mapper;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TourLogMapperTest {

    @Autowired
    private TourLogMapper tourLogMapper;

    @Test
    public void testFromEntity() {
        // Create a sample TourLogEntity
        TourLogEntity tourLogEntity = TourLogEntity.builder()
                .id(1L)
                .time("10:00")
                .comment("A beautiful tour log")
                .difficulty("3")
                .totalTime("2 hours")
                .rating("2")
                .tourEntity(new TourEntity())
                .build();

        // Map TourLogEntity to TourLog using the TourLogMapper
        TourLog tourLog = tourLogMapper.fromEntity(tourLogEntity);

        // Verify the mapped TourLog object
        assertEquals(tourLogEntity.getId(), tourLog.getId());
        assertEquals(tourLogEntity.getTime(), tourLog.getTime());
        assertEquals(tourLogEntity.getComment(), tourLog.getComment());
        assertEquals(tourLogEntity.getDifficulty(), tourLog.getDifficulty());
        assertEquals(tourLogEntity.getTotalTime(), tourLog.getTotalTime());
        assertEquals(tourLogEntity.getRating(), tourLog.getRating());
        assertEquals(tourLogEntity.getTourEntity(), tourLog.getTourEntity());
    }

    @Test
    public void testToEntity() {
        // Create a sample TourLog object
        TourLog tourLog = TourLog.builder()
                .id(1L)
                .time("10:00 AM")
                .comment("A beautiful tour log")
                .difficulty("3")
                .totalTime("2 hours")
                .rating("2")
                .tourEntity(new TourEntity())
                .build();

        // Map TourLog to TourLogEntity using the TourLogMapper
        TourLogEntity tourLogEntity = tourLogMapper.toEntity(tourLog);

        // Verify the mapped TourLogEntity object
        assertEquals(tourLog.getId(), tourLogEntity.getId());
        assertEquals(tourLog.getTime(), tourLogEntity.getTime());
        assertEquals(tourLog.getComment(), tourLogEntity.getComment());
        assertEquals(tourLog.getDifficulty(), tourLogEntity.getDifficulty());
        assertEquals(tourLog.getTotalTime(), tourLogEntity.getTotalTime());
        assertEquals(tourLog.getRating(), tourLogEntity.getRating());
        assertEquals(tourLog.getTourEntity(), tourLogEntity.getTourEntity());
    }
}

