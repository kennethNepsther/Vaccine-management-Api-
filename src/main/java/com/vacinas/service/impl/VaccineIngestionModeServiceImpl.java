package com.vacinas.service.impl;

import com.vacinas.exception.ObjectNotFoundException;
import com.vacinas.model.VaccineIngestionMode;
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
    public VaccineIngestionMode findById(Long id) {
        Optional<VaccineIngestionMode> vaccineIngestionMode = vaccineIngestionModeRepository.findById(id);
        return vaccineIngestionMode.orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado  objecto com o indetificador "+ id));

    }

    @Override
    public List<VaccineIngestionMode> findAll() {
        return vaccineIngestionModeRepository.findAll();
    }

    @Override
    public VaccineIngestionMode create(VaccineIngestionMode vaccineIngestionMode) {
        vaccineIngestionMode.setId(null);
        return vaccineIngestionModeRepository.save(vaccineIngestionMode);
    }

    @Override
    public VaccineIngestionMode update(Long id, VaccineIngestionMode vaccineIngestionMode) {
        return null;
    }

    @Override
    public void delete(Long id) {
        findById(id);
        vaccineIngestionModeRepository.deleteById(id);

    }
}
