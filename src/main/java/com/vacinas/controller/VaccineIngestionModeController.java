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
@RequestMapping("/v1/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VaccineIngestionModeController {

    final VaccineIngestionModeService vaccineIngestionModeService;

    @GetMapping("/{id}")
    public ResponseEntity<VaccineIngestionMode> findById(@PathVariable Long id) {
        VaccineIngestionMode category = vaccineIngestionModeService.findById(id);
        return ResponseEntity.ok((category));
    }

    @GetMapping
    public ResponseEntity<List<VaccineIngestionMode>> findAll() {
        List<VaccineIngestionMode> category = vaccineIngestionModeService.findAll();
        return ResponseEntity.ok().body(category);
        //return ResponseEntity.ok(product.stream().map(productDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<VaccineIngestionMode> create(@RequestBody VaccineIngestionMode category){
        category = vaccineIngestionModeService.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        vaccineIngestionModeService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
