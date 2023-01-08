package com.vacinas.controller;

import com.vacinas.model.UserModel;
import com.vacinas.model.dto.request.UserRequestDto;
import com.vacinas.model.dto.request.UserRoleDTO;
import com.vacinas.model.dto.response.UserResponseDto;
import com.vacinas.service.AssignRolesToUserService;
import com.vacinas.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<UserModel> findById(@PathVariable Long id) {
        UserModel userModel = userService.findById(id);
        return ResponseEntity.ok((userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<UserModel> userModels = userService.findAll();
        return ResponseEntity.ok().body(UserResponseDto.convertToList(userModels));
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserRequestDto userDTO) {
        UserModel userModel = userService.create(userDTO.build());
        URI uri = addIdToCurrentUrlPath(userModel.getId());
        return ResponseEntity.created(uri).body(userModel);
    }

    @PostMapping("/set-role")
    public ResponseEntity<UserModel> setUserRole(@RequestBody UserRoleDTO userRoleDto) {
        return ResponseEntity.ok().body(assignRolesToUserService.execute(userRoleDto));
    }

    @PutMapping
    public ResponseEntity<UserModel> update(@RequestBody UserRequestDto userDTO) {
        var user = new UserModel();
        UserRequestDto.update(userDTO, user);
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        userService.delete(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado com sucesso.");

    }

}
