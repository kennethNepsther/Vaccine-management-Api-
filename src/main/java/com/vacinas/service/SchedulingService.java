package com.vacinas.service;

import com.vacinas.model.SchedulingModel;
import com.vacinas.model.VaccineModel;

import java.util.List;

public interface SchedulingService {

    SchedulingModel findById(Long id);

    List<SchedulingModel> findAll();

    SchedulingModel create(SchedulingModel schedulingModel);
    SchedulingModel update(Long id, SchedulingModel schedulingModel);

    void delete(Long id);
}
