package at.fhtw.swen2.tutorial.utils;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.junit.jupiter.api.Test;

public class BuilderTest {

    @Test
    void testTourEntityBuilder() {
        TourEntity First = TourEntity.builder()
                .name("First")
                .tourDescription("1")
                .from("here")
                .to("there")
                .transportType("")
                .build();
    }
    @Test
    void testTourBuilder() {
        Tour First = Tour.builder()
                .name("First")
                .id(11L)
                .build();
    }


}
