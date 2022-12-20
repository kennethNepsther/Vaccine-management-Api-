package com.vacinas.repository;

import com.vacinas.model.VaccineIngestionMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineIngestionModeRepository extends JpaRepository<VaccineIngestionMode, Long> {
}
