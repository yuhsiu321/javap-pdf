package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class FindUpdateTourLogViewModel {
    @Autowired
    private TourLogService tourLogService;
    @Autowired
    private TourLogListViewModel tourLogListViewModel;

    private final SimpleStringProperty findUpdateComment = new SimpleStringProperty();

    public String getFindUpdateComment() {
        return findUpdateComment.get();
    }



    public SimpleStringProperty FindUpdateCommentProperty() {
        return findUpdateComment;
    }

    public void setFindUpdateComment(String findUpdateComment) {
        this.findUpdateComment.set(findUpdateComment);
    }

    public TourLog findUpdateLog() {
        TourLog tourLog = tourLogService.findByComment(getFindUpdateComment());

        return tourLog;

        //show tour detail

    }

}
