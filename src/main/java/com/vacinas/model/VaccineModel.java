package com.vacinas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vacinas.enums.VaccineIntakeRoute;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "vaccine")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VaccineModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String allotment;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VaccineIntakeRoute intakeRoute;

    @OneToMany(mappedBy = "vaccine", cascade = CascadeType.ALL)
    private List<VaccineIngestionMode> ingestionModes;



}
