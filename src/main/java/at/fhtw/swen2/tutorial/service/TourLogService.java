package at.fhtw.swen2.tutorial.service;

import at.fhtw.swen2.tutorial.service.dto.TourLog;

import java.util.List;

public interface TourLogService {

    List<TourLog> getTourLogList();

    TourLog addnew(TourLog tourLog);

    void delete(String name);

    TourLog findByComment(String deleteComment);

    TourLog updateTourLog(TourLog tourLog);

    //void delete(Long id);

}
