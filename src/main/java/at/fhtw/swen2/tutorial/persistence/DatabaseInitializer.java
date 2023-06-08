package at.fhtw.swen2.tutorial.persistence;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class DatabaseInitializer implements InitializingBean {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TourLogRepository tourLogRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        tourLogRepository.deleteAll();
        tourRepository.deleteAll();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Calendar obj = Calendar.getInstance();

        List<TourEntity> tourList = new ArrayList<>();
        tourList.add(TourEntity.builder().id(5L).name("First").tourDescription("1").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(7L).name("Second").tourDescription("2").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(11L).name("Third").tourDescription("3").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(13L).name("Last").tourDescription("4").from("there").to("here").build());

        tourRepository.saveAll(tourList);

        TourLogEntity first = TourLogEntity.builder().id(5L).time(formatter.format(obj.getTime())).comment("1234246").tourEntity(tourRepository.findByName("Third")).build();

        tourLogRepository.save(first);
    }

    public static List<Tour> getInitialDemoDataDtos() {
        List<Tour> tourList = new ArrayList<>();
        tourList.add(Tour.builder().id(5L).name("First").tourDescription("1").from("here").to("there").build());
        tourList.add(Tour.builder().id(7L).name("Second").tourDescription("2").from("here").to("there").build());
        tourList.add(Tour.builder().id(11L).name("Third").tourDescription("3").from("here").to("there").build());
        tourList.add(Tour.builder().id(13L).name("Last").tourDescription("4").from("there").to("here").build());
        return tourList;
    }
}
