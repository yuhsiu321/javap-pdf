package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.SimpleStringProperty;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTourLogViewModel {
    @Autowired
    private TourLogRepository tourLogRepository;
    @Autowired
    private TourLogService tourLogService;

    @Autowired
    private TourLogListViewModel tourLogListViewModel;

    private SimpleStringProperty deleteComment = new SimpleStringProperty();

    public String getDeleteComment() {
        return deleteComment.get();
    }

    public SimpleStringProperty deleteCommentProperty() {
        return deleteComment;
    }

    public void setDeleteComment(String deleteComment) {
        this.deleteComment.set(deleteComment);
    }

    public void delete() {
        TourLog tourLog = tourLogService.findByComment(getDeleteComment());
        tourLogListViewModel.deleteItem(tourLog.getComment());
        tourLogService.delete(tourLog.getComment());
    }

}
