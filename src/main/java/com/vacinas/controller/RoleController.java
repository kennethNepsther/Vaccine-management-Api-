package com.vacinas.controller;

import com.vacinas.model.RoleModel;
import com.vacinas.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/role")
@PreAuthorize("hasRole('ADMIN')")
public class RoleController {

    final RoleService roleService;


    @GetMapping("/{id}")
    public ResponseEntity<RoleModel> findById(@PathVariable Long id) {
        RoleModel roleModel = roleService.findById(id);
        return ResponseEntity.ok((roleModel));
    }

    @GetMapping
    public ResponseEntity<List<RoleModel>> findAll() {
        List<RoleModel> roleModels = roleService.findAll();
        return ResponseEntity.ok().body(roleModels);
    }

    @PostMapping
    public ResponseEntity<RoleModel> create(@RequestBody RoleModel roleModel){
        roleModel = roleService.create(roleModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(roleModel.getId()).toUri();
        return ResponseEntity.created(uri).body(roleModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        roleService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
