package com.vacinas.repository;

import com.vacinas.model.VaccineIngestionModeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineIngestionModeRepository extends JpaRepository<VaccineIngestionModeModel, Long> {
}
