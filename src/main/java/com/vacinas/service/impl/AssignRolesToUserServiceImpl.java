package com.vacinas.service.impl;

import com.vacinas.exception.DataIntegrityViolationException;
import com.vacinas.model.Role;
import com.vacinas.model.User;
import com.vacinas.model.dto.UserRoleDTO;
import com.vacinas.repository.UserRepository;
import com.vacinas.service.AssignRolesToUserService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
public class AssignRolesToUserServiceImpl implements AssignRolesToUserService {

    final UserRepository userRepository;

    @Override
    public User execute(UserRoleDTO userRoleDTO) {
            Optional<User> userExists = userRepository.findById(userRoleDTO.getId());
            List<Role> roles;

            if (userExists.isEmpty()) {
                throw new DataIntegrityViolationException("Permissão já existente");
            }

            roles = userRoleDTO.getIdsRoles().stream().map(Role::new).collect(Collectors.toList());

        /* Alternatively
        roles = userRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());
        */

            User user = userExists.get();
            user.setRoles(roles);

            userRepository.save(user);

            return user;

        }
    }

