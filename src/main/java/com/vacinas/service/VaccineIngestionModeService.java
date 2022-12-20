package com.vacinas.service;

import com.vacinas.model.VaccineIngestionMode;

import java.util.List;

public interface VaccineIngestionModeService {

    VaccineIngestionMode findById(Long id);

    List<VaccineIngestionMode> findAll();

    VaccineIngestionMode create(VaccineIngestionMode vaccineIngestionMode);

    VaccineIngestionMode update(Long id, VaccineIngestionMode vaccineIngestionMode);

    void delete(Long id);
}
