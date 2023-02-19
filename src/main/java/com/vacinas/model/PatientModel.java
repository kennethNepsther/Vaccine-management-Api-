package com.vacinas.model;

import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idNumber;
    private String fullName;
    private LocalDate brithDate;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.REMOVE)
    private List<SchedulingModel> schedulingList = new ArrayList<>();

}
