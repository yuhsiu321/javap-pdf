package at.fhtw.swen2.tutorial.persistence.entities;

import at.fhtw.swen2.tutorial.service.dto.TourLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "TOUR_DESCRIPTION")
    private String tourDescription;
    @Column(name = "FROM_WHERE")
    private String from;
    @Column(name = "TO_WHERE")
    private String to;
    private String transportType;
    private Double tourDistance;
    private Integer estimatedTime;
    private String routeInformation;

    @OneToMany(mappedBy = "tourEntity")
    private List<TourLogEntity> tourLogs;

}
