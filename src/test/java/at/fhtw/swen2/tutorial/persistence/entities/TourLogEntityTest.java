package at.fhtw.swen2.tutorial.persistence.entities;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class TourLogEntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TourLogRepository tourLogRepository;

    @Test
    void testTourLogEntity() {
        TourEntity tour = TourEntity.builder()
                .name("First")
                .tourDescription("1")
                .from("here")
                .to("There")
                .transportType("")
                .build();

        TourLogEntity tourLog = TourLogEntity.builder()
                .time("10:00")
                .comment("1234246")
                .difficulty("Medium")
                .totalTime("2 hours")
                .rating("4")
                .tourEntity(tour)
                .build();

        tourRepository.save(tour);
        tourLogRepository.save(tourLog);

        entityManager.flush();
        entityManager.clear();

        TourLogEntity savedTourLog = tourLogRepository.findById(tourLog.getId()).orElse(null);
        assertNotNull(savedTourLog);
        assertEquals("10:00", savedTourLog.getTime());
        assertEquals("1234246", savedTourLog.getComment());
        assertEquals("Medium", savedTourLog.getDifficulty());
        assertEquals("2 hours", savedTourLog.getTotalTime());
        assertEquals("4", savedTourLog.getRating());
        assertEquals(tour.getId(), savedTourLog.getTourEntity().getId());
    }
}

