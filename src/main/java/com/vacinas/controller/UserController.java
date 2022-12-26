package com.vacinas.controller;

import com.vacinas.model.User;
import com.vacinas.model.dto.UserRoleDTO;
import com.vacinas.service.AssignRolesToUserService;
import com.vacinas.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    final UserService userService;

    final AssignRolesToUserService assignRolesToUserService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok((user));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
        //return ResponseEntity.ok(product.stream().map(productDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        user = userService.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PostMapping("/set-role")
    public ResponseEntity<User> setUserRole(@RequestBody UserRoleDTO userRoleDto){
        return ResponseEntity.ok().body(assignRolesToUserService.execute(userRoleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
