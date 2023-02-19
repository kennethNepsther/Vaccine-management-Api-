package com.vacinas.service.impl;

import com.vacinas.exception.ObjectNotFoundException;
import com.vacinas.model.PatientModel;
import com.vacinas.model.SchedulingModel;
import com.vacinas.repository.PatientRepository;
import com.vacinas.repository.SchedulingRepository;
import com.vacinas.service.PatientService;
import com.vacinas.service.SchedulingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    final PatientRepository patientRepository;

    @Override
    public PatientModel findById(Long id) {
        Optional<PatientModel> scheduling = patientRepository.findById(id);
        return scheduling.orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado  objecto com o indetificador "+ id ));
    }

    @Override
    public List<PatientModel> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public PatientModel create(PatientModel patientModel) {
        patientModel.setId(null);
        return patientRepository.save(patientModel);
    }


    @Override
    public PatientModel update(Long id, PatientModel patientModel) {
        return null;
    }

    @Override
    public void delete(Long id) {
        findById(id);
        patientRepository.deleteById(id);

    }
}
