package com.vacinas.model;

import lombok.*;
import lombok.experimental.Accessors;
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
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "patient")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String idNumber;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private LocalDate brithDate;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.REMOVE)
    private List<SchedulingModel> schedulingList = new ArrayList<>();

}
