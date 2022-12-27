package com.vacinas.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;




@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = " schedule")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SchedulingModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate scheduleDate;
    private LocalTime scheduleHours;
    private String scheduleLocation;


}
