package com.vacinas.controller;

import com.vacinas.model.PatientModel;
import com.vacinas.model.VaccineModel;
import com.vacinas.model.dto.request.PatientRequestDto;
import com.vacinas.model.dto.request.VaccineRequestDto;
import com.vacinas.service.PatientService;
import com.vacinas.service.VaccineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.vacinas.util.UriUtil.addIdToCurrentUrlPath;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/patient")
@PreAuthorize("hasRole('ADMIN')")
public class PatientController {

    final PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> findById(@PathVariable Long id) {
        PatientModel patient = patientService.findById(id);
        return ResponseEntity.ok((patient));
    }

    @GetMapping
    public ResponseEntity<List<PatientModel>> findAll() {
        List<PatientModel> patient = patientService.findAll();
        return ResponseEntity.ok().body(patient);
        //return ResponseEntity.ok(product.stream().map(productDTO::new).collect(Collectors.toList()));
    }



    @PostMapping
    public ResponseEntity<PatientModel> create(@RequestBody PatientRequestDto patientDto){
        PatientModel patient = patientService.create(patientDto.build());
        URI uri = addIdToCurrentUrlPath(patient.getId());
        return ResponseEntity.created(uri).body(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        patientService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
