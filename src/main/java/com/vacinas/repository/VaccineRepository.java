package com.vacinas.repository;

import com.vacinas.model.VaccineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineModel, Long> {

    List<VaccineModel> findVaccineModelsByAllotment(String allotment);
    List<VaccineModel> findVaccineModelsByManufactureDateOrExpirationDate(LocalDate manufactureDate, LocalDate expirationDate);
}
