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
class TourEntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TourLogRepository tourLogRepository;

    @Test
    void testTourEntity() {
        TourEntity tour = TourEntity.builder()
                .name("First")
                .tourDescription("1")
                .from("here")
                .to("there")
                .transportType("")
                .build();


        tourRepository.save(tour);

        entityManager.flush();
        entityManager.clear();

        TourEntity savedTour = tourRepository.findById(tour.getId()).orElse(null);
        assertNotNull(savedTour);
        assertEquals("First", savedTour.getName());
        assertEquals("1", savedTour.getTourDescription());
        assertEquals("here", savedTour.getFrom());
        assertEquals("there", savedTour.getTo());

    }

    @Test
    void testTourEntity2() {
        TourEntity tour = TourEntity.builder()
                .name("Second")
                .tourDescription("2")
                .from("here")
                .to("there")
                .transportType("")
                .build();


        tourRepository.save(tour);

        entityManager.flush();
        entityManager.clear();

        TourEntity savedTour = tourRepository.findById(tour.getId()).orElse(null);
        assertNotNull(savedTour);
        assertEquals("Second", savedTour.getName());
        assertEquals("2", savedTour.getTourDescription());
        assertEquals("here", savedTour.getFrom());
        assertEquals("there", savedTour.getTo());

    }
}
