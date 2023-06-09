package at.fhtw.swen2.tutorial.persistence.repositories;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourLogRepository extends JpaRepository<TourLogEntity, Long> {
    //void delete(Optional<TourLogEntity> byId);
    TourLogEntity findByComment(String comment);
}
