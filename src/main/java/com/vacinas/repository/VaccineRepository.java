package com.vacinas.repository;

import com.vacinas.model.VaccineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineModel, Long> {
}
