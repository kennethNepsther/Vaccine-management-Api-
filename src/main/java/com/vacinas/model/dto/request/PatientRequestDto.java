package com.vacinas.model.dto.request;

import com.vacinas.model.PatientModel;
import com.vacinas.model.SchedulingModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDto {
    @NotBlank
    @Size(min = 3, max = 50)
    @NotNull(message = "O nome  é obrigatório")
    private String idNumber;
    @NotBlank
    @Size(min = 3, max = 50)
    @NotNull(message = "O nome  é obrigatório")
    private String fullName;
    @NotNull(message = "A Data de nascimento  é obrigatório")
    private LocalDate brithDate;


    public PatientModel build() {
        return new PatientModel()
                .setIdNumber(this.idNumber)
                .setFullName(this.fullName)
                .setBrithDate(this.brithDate);


    }
}
