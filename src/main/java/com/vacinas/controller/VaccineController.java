package com.vacinas.controller;

import com.vacinas.model.VaccineModel;
import com.vacinas.service.VaccineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/product")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VaccineController {

    final VaccineService vaccineService;

    @GetMapping("/{id}")
    public ResponseEntity<VaccineModel> findById(@PathVariable Long id) {
        VaccineModel product = vaccineService.findById(id);
        return ResponseEntity.ok((product));
    }

    @GetMapping
    public ResponseEntity<List<VaccineModel>> findAll() {
        List<VaccineModel> product = vaccineService.findAll();
        return ResponseEntity.ok().body(product);
        //return ResponseEntity.ok(product.stream().map(productDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<VaccineModel> create(@RequestBody VaccineModel product){
        product = vaccineService.create(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        vaccineService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
