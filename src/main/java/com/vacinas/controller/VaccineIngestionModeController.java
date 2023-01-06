package com.vacinas.controller;

import com.vacinas.model.VaccineIngestionModeModel;
import com.vacinas.service.VaccineIngestionModeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/v1/ingestion")
public class VaccineIngestionModeController {

    final VaccineIngestionModeService vaccineIngestionModeService;

    @GetMapping("/{id}")
    public ResponseEntity<VaccineIngestionModeModel> findById(@PathVariable Long id) {
        VaccineIngestionModeModel ingestion = vaccineIngestionModeService.findById(id);
        return ResponseEntity.ok((ingestion));
    }

    @GetMapping
    public ResponseEntity<List<VaccineIngestionModeModel>> findAll() {
        List<VaccineIngestionModeModel> ingestion = vaccineIngestionModeService.findAll();
        return ResponseEntity.ok().body(ingestion);
        //return ResponseEntity.ok(product.stream().map(productDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<VaccineIngestionModeModel> create(@RequestBody VaccineIngestionModeModel ingestion){
        ingestion = vaccineIngestionModeService.create(ingestion);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ingestion.getId()).toUri();
        return ResponseEntity.created(uri).body(ingestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        vaccineIngestionModeService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
