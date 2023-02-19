package com.vacinas.service.impl;

import com.vacinas.exception.ObjectNotFoundException;
import com.vacinas.model.SchedulingModel;
import com.vacinas.model.VaccineModel;
import com.vacinas.repository.SchedulingRepository;
import com.vacinas.repository.VaccineRepository;
import com.vacinas.service.SchedulingService;
import com.vacinas.service.VaccineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SchedulingServiceImpl implements SchedulingService {
    final SchedulingRepository schedulingRepository;

    @Override
    public SchedulingModel findById(Long id) {
        Optional<SchedulingModel> scheduling = schedulingRepository.findById(id);
        return scheduling.orElseThrow(()-> new ObjectNotFoundException("Não foi encontrado  objecto com o indetificador "+ id ));
    }

    @Override
    public List<SchedulingModel> findAll() {
        return schedulingRepository.findAll();
    }

    @Override
    public SchedulingModel create(SchedulingModel schedulingModel) {
        schedulingModel.setId(null);
        return schedulingRepository.save(schedulingModel);
    }


    @Override
    public SchedulingModel update(Long id, SchedulingModel schedulingModel) {
        return null;
    }

    @Override
    public void delete(Long id) {
        findById(id);
        schedulingRepository.deleteById(id);

    }
}
