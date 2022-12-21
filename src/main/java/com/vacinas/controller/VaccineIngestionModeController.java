package com.vacinas.controller;

import com.vacinas.model.VaccineIngestionMode;
import com.vacinas.service.VaccineIngestionModeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/ingestion")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VaccineIngestionModeController {

    final VaccineIngestionModeService vaccineIngestionModeService;

    @GetMapping("/{id}")
    public ResponseEntity<VaccineIngestionMode> findById(@PathVariable Long id) {
        VaccineIngestionMode ingestion = vaccineIngestionModeService.findById(id);
        return ResponseEntity.ok((ingestion));
    }

    @GetMapping
    public ResponseEntity<List<VaccineIngestionMode>> findAll() {
        List<VaccineIngestionMode> ingestion = vaccineIngestionModeService.findAll();
        return ResponseEntity.ok().body(ingestion);
        //return ResponseEntity.ok(product.stream().map(productDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<VaccineIngestionMode> create(@RequestBody VaccineIngestionMode ingestion){
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
