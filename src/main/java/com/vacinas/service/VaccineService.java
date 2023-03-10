package com.vacinas.service;

import com.vacinas.model.VaccineModel;

import java.util.List;

public interface VaccineService {

    VaccineModel findById(Long id);

    List<VaccineModel> findAll();

    List<VaccineModel> findByAllotment(String allotment);

    VaccineModel create(VaccineModel vaccineModel);

    VaccineModel update(Long id, VaccineModel vaccineModel);

    void delete(Long id);
}
