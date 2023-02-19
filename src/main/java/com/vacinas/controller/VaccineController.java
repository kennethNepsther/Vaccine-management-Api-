package com.vacinas.controller;

import com.vacinas.model.VaccineModel;
import com.vacinas.model.dto.request.VaccineRequestDto;
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
@RequestMapping("/v1/vaccine")
@PreAuthorize("hasRole('ADMIN')")
public class VaccineController {

    final VaccineService vaccineService;

    @GetMapping("/{id}")
    public ResponseEntity<VaccineModel> findById(@PathVariable Long id) {
        VaccineModel vaccine = vaccineService.findById(id);
        return ResponseEntity.ok((vaccine));
    }

    @GetMapping
    public ResponseEntity<List<VaccineModel>> findAll() {
        List<VaccineModel> vaccine = vaccineService.findAll();
        return ResponseEntity.ok().body(vaccine);
        //return ResponseEntity.ok(product.stream().map(productDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/allotment/{allotment}")
    public ResponseEntity<List<VaccineModel>> findAllotment(@PathVariable String allotment) {
        List<VaccineModel> vaccine = vaccineService.findByAllotment(allotment);
        return ResponseEntity.ok().body(vaccine);

    }

    @PostMapping
    public ResponseEntity<VaccineModel> create(@RequestBody VaccineRequestDto vaccineDto){
        VaccineModel vaccine = vaccineService.create(vaccineDto.build());
        URI uri = addIdToCurrentUrlPath(vaccine.getId());
        return ResponseEntity.created(uri).body(vaccine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        vaccineService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
