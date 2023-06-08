package at.fhtw.swen2.tutorial.persistence;

import at.fhtw.swen2.tutorial.persistence.DatabaseInitializer;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class DatabaseInitializerTest {

    @Autowired
    private DatabaseInitializer databaseInitializer;

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TourLogRepository tourLogRepository;

    @Test
    void testDatabaseInitializer() throws Exception {
        // Perform assertions or additional testing here
        databaseInitializer.afterPropertiesSet();

        // Example assertions

        assertEquals(4, tourRepository.count());
        assertNotNull(tourRepository.findByName("First"));
        assertNotNull(tourRepository.findByName("Second"));
        assertNotNull(tourRepository.findByName("Third"));
        assertNotNull(tourRepository.findByName("Last"));


        assertEquals(1, tourLogRepository.count());
        //assertNotNull(tourLogRepository.findById(5L).orElse(null));
    }
}
