package com.vacinas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingestion_mode")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VaccineIngestionModeModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private String vaccinationSchedule;

    private String guidelines;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private VaccineModel vaccine;

}
