package com.vacinas.service.impl;

import com.vacinas.model.VaccineModel;
import com.vacinas.repository.VaccineRepository;
import com.vacinas.service.VaccineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VaccineServiceImpl implements VaccineService {
    final VaccineRepository vaccineRepository;

    @Override
    public VaccineModel findById(Long id) {
        Optional<VaccineModel> newObj = vaccineRepository.findById(id);
        return newObj.orElse(null);    }

    @Override
    public List<VaccineModel> findAll() {
        return vaccineRepository.findAll();
    }

    @Override
    public VaccineModel create(VaccineModel vaccineModel) {
        vaccineModel.setId(null);
        return vaccineRepository.save(vaccineModel);
    }

    @Override
    public VaccineModel update(Long id, VaccineModel vaccineModel) {
        return null;
    }

    @Override
    public void delete(Long id) {
        findById(id);
        vaccineRepository.deleteById(id);

    }
}
