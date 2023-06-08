package at.fhtw.swen2.tutorial.service.mapper;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import org.springframework.stereotype.Component;

@Component
public class TourLogMapper extends AbstractMapper<TourLogEntity, TourLog>{
    @Override
    public TourLog fromEntity(TourLogEntity entity) {
        return TourLog.builder()
                .id(entity.getId())
                .time(entity.getTime())
                .comment(entity.getComment())
                .difficulty(entity.getDifficulty())
                .totalTime(entity.getTotalTime())
                .rating(entity.getRating())
                .tourEntity(entity.getTourEntity())
                .build();
    }

    @Override
    public TourLogEntity toEntity(TourLog dto) {
        return TourLogEntity.builder()
                .id(dto.getId())
                .time(dto.getTime())
                .comment(dto.getComment())
                .difficulty(dto.getDifficulty())
                .totalTime(dto.getTotalTime())
                .rating(dto.getRating())
                .tourEntity(dto.getTourEntity())
                .build();
    }
}
