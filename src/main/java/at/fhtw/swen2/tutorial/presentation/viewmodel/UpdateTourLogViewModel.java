package at.fhtw.swen2.tutorial.presentation.viewmodel;


import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTourLogViewModel {

    @Autowired
    private TourLogService tourLogService;

    @Autowired
    private FindUpdateTourLogViewModel findUpdateTourLogViewModel;

    private SimpleStringProperty comment = new SimpleStringProperty();

    private SimpleStringProperty tourName = new SimpleStringProperty();

    private SimpleStringProperty time = new SimpleStringProperty();

    private StringProperty rating = new SimpleStringProperty();

    private StringProperty difficult = new SimpleStringProperty();

    public void update(StringProperty updateComment, StringProperty updateTourName, StringProperty updateTime,  ObjectProperty<String> updateRating, ObjectProperty<String> updateDifficult){
        TourLog tourLog = TourLog.builder().comment(updateComment.getValue()).tourName(updateTourName.getValue()).totalTime(updateTime.getValue()).difficulty(updateDifficult.getValue()).rating(updateRating.getValue()).build();
        //String tourName = tourLog.getTourEntity().getName();
        TourLog oldTourLog = findUpdateTourLogViewModel.findUpdateLog();
        //oldTourLog.setTourName(tourLog.getValue());
        oldTourLog.setComment(tourLog.getComment());
        oldTourLog.setTotalTime(tourLog.getTotalTime());
        oldTourLog.setRating(tourLog.getRating());
        oldTourLog.setDifficulty(tourLog.getDifficulty());
        TourLog newTourLog = tourLogService.updateTourLog(oldTourLog);
        //System.out.println(newTourLog);
    }


}
