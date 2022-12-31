package com.vacinas.service;

import com.vacinas.model.VaccineIngestionModeModel;

import java.util.List;

public interface VaccineIngestionModeService {

    VaccineIngestionModeModel findById(Long id);

    List<VaccineIngestionModeModel> findAll();

    VaccineIngestionModeModel create(VaccineIngestionModeModel vaccineIngestionModeModel);

    VaccineIngestionModeModel update(Long id, VaccineIngestionModeModel vaccineIngestionModeModel);

    void delete(Long id);
}
