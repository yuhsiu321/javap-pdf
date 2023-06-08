package at.fhtw.swen2.tutorial.service.dto;

import at.fhtw.swen2.tutorial.service.dto.TourLog;
import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TourLogTest {

    @Test
    public void testTourLogBuilder() {
        Long id = 1L;
        String time = "10:00";
        String comment = "Great tour!";
        String difficulty = "1";
        String totalTime = "2 hours";
        String rating = "5 stars";
        TourEntity tourEntity = new TourEntity();
        String tourName = "First";

        TourLog tourLog = TourLog.builder()
                .id(id)
                .time(time)
                .comment(comment)
                .difficulty(difficulty)
                .totalTime(totalTime)
                .rating(rating)
                .tourEntity(tourEntity)
                .tourName(tourName)
                .build();

        assertNotNull(tourLog);
        assertEquals(id, tourLog.getId());
        assertEquals(time, tourLog.getTime());
        assertEquals(comment, tourLog.getComment());
        assertEquals(difficulty, tourLog.getDifficulty());
        assertEquals(totalTime, tourLog.getTotalTime());
        assertEquals(rating, tourLog.getRating());
        assertEquals(tourEntity, tourLog.getTourEntity());
        assertEquals(tourName, tourLog.getTourName());
    }
}
