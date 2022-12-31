package com.vacinas.service.impl;

import com.vacinas.exception.ObjectNotFoundException;
import com.vacinas.model.VaccineIngestionModeModel;
import com.vacinas.repository.VaccineIngestionModeRepository;
import com.vacinas.service.VaccineIngestionModeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VaccineIngestionModeServiceImpl implements VaccineIngestionModeService {

    final VaccineIngestionModeRepository vaccineIngestionModeRepository;

    @Override
    public VaccineIngestionModeModel findById(Long id) {
        Optional<VaccineIngestionModeModel> vaccineIngestionMode = vaccineIngestionModeRepository.findById(id);
        return vaccineIngestionMode.orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado  objecto com o indetificador "+ id));

    }

    @Override
    public List<VaccineIngestionModeModel> findAll() {
        return vaccineIngestionModeRepository.findAll();
    }

    @Override
    public VaccineIngestionModeModel create(VaccineIngestionModeModel vaccineIngestionModeModel) {
        vaccineIngestionModeModel.setId(null);
        return vaccineIngestionModeRepository.save(vaccineIngestionModeModel);
    }

    @Override
    public VaccineIngestionModeModel update(Long id, VaccineIngestionModeModel vaccineIngestionModeModel) {
        return null;
    }

    @Override
    public void delete(Long id) {
        findById(id);
        vaccineIngestionModeRepository.deleteById(id);

    }
}
