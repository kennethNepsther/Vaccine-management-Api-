package com.vacinas.controller;

import com.vacinas.model.User;
import com.vacinas.model.dto.request.UserRequestDto;
import com.vacinas.model.dto.request.UserRoleDTO;
import com.vacinas.model.dto.response.UserResponseDto;
import com.vacinas.service.AssignRolesToUserService;
import com.vacinas.service.UserService;
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
@RequestMapping("/v1/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    final UserService userService;

    final AssignRolesToUserService assignRolesToUserService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok((user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(UserResponseDto.convertToList(users));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserRequestDto userRequestDto){
        User user = userService.create(userRequestDto.build());
        URI uri = addIdToCurrentUrlPath(user.getId());
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
