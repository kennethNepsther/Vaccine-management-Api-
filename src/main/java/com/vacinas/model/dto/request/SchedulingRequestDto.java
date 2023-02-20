package com.vacinas.model.dto.request;


import com.vacinas.model.PatientModel;
import com.vacinas.model.SchedulingModel;
import com.vacinas.model.VaccineModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingRequestDto {

    @NotBlank
    @NotNull(message = "O nome  é obrigatória")
    private LocalDate scheduleDate;
    @NotBlank
    @NotNull(message = "A hora  é obrigatória")
    private LocalTime scheduleHours;
    @NotBlank
    @NotNull(message = "A localização  é obrigatório")
    private String scheduleLocation;

    @NotNull(message = "O paciente  é obrigatório")
    private PatientModel patient;

    @NotNull(message = "A vacine  é obrigatória")
    private VaccineModel vaccine;

    public SchedulingModel build() {
        return new SchedulingModel()
                .setScheduleDate(this.scheduleDate)
                .setScheduleHours(this.scheduleHours)
                .setScheduleLocation(this.scheduleLocation)
                .setPatient(this.patient)
                .setVaccine(this.vaccine);

    }
}
