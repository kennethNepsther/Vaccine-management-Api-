package com.vacinas.repository;

import com.vacinas.model.PatientModel;
import com.vacinas.model.SchedulingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<SchedulingModel, Long> {


}
