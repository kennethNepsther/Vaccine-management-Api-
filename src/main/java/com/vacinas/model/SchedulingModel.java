package com.vacinas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;




@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = " schedule")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SchedulingModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate scheduleDate;
    @Column(nullable = false)
    private LocalTime scheduleHours;
    @Column(nullable = false)
    private String scheduleLocation;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientModel patient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private VaccineModel vaccine;


}
