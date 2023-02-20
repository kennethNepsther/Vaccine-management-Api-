package com.vacinas.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vacinas.enums.VaccineIntakeRoute;

import com.vacinas.model.VaccineModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineRequestDto {

    @NotBlank
    @Size(min = 3, max = 20)
    @NotNull(message = "O nome é obrigatório")
    private String name;
    @NotBlank
    @Size(min = 3, max = 20)
    @NotNull(message = "A descrição é obrigatória")
    private String description;
    @NotBlank
    @Size(min = 3, max = 20)
    @NotNull(message = "O numero de série é obrigatório")
    private String allotment;
    @NotBlank
    @Size(min = 3)
    @NotNull(message = "O nome  do fabricante é obrigatório")
    private String manufacturer;
    @NotBlank
    @NotNull(message = "A data de fabrico é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;
    @NotBlank
    @NotNull(message = "A data de expiração é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    @NotBlank
    @Size(min = 3, max = 20)
    @NotNull(message = "O nome é obrigatório")

    @Enumerated(EnumType.STRING)
    private VaccineIntakeRoute intakeRoute;

    @NotBlank
    @Size(min = 3, max = 20)
    @NotNull(message = "O nome é obrigatório")
    private String vaccinationSchedule;

    @NotBlank
    @Size(min = 3, max = 20)
    @NotNull(message = "O nome é obrigatório")
    private String ingestionMode;


    public VaccineModel build() {
        return new VaccineModel()
                .setName(this.name)
                .setDescription(this.description)
                .setAllotment(this.allotment)
                .setManufacturer(this.manufacturer)
                .setIntakeRoute(this.intakeRoute)
                .setManufactureDate(this.manufactureDate)
                .setExpirationDate(this.expirationDate)
                .setVaccinationSchedule(this.vaccinationSchedule)
                .setIngestionMode(this.ingestionMode);

    }


    public static void update(VaccineRequestDto vaccineRequestDto, VaccineModel vaccineModel){
        BeanUtils.copyProperties(vaccineRequestDto, vaccineModel);
        //vaccineModel.setId(vaccineRequestDto.getId());
        vaccineModel.setName(vaccineRequestDto.getName());
        vaccineModel.setDescription(vaccineRequestDto.getDescription());
        vaccineModel.setIntakeRoute(vaccineRequestDto.getIntakeRoute());
        vaccineModel.setManufacturer(vaccineRequestDto.getManufacturer());
        vaccineModel.setManufactureDate(vaccineRequestDto.getManufactureDate());
        vaccineModel.setExpirationDate(vaccineRequestDto.getExpirationDate());
        vaccineModel.setExpirationDate(vaccineRequestDto.getExpirationDate());



    }




}
