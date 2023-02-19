package com.vacinas.service;

import com.vacinas.model.PatientModel;
import com.vacinas.model.SchedulingModel;
import com.vacinas.model.VaccineModel;

import java.util.List;

public interface PatientService {

    PatientModel findById(Long id);

    List<PatientModel> findAll();

    PatientModel create(PatientModel patientModel);
    PatientModel update(Long id, PatientModel patientModel);

    void delete(Long id);
}
