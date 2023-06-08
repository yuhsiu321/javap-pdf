package at.fhtw.swen2.tutorial.persistence.repositories;


import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<TourEntity, Long> {

    TourEntity findByName(String name);
}
