package com.vacinas.service.impl;

import com.vacinas.exception.DataIntegrityViolationException;
import com.vacinas.model.RoleModel;
import com.vacinas.model.UserModel;
import com.vacinas.model.dto.request.UserRoleDTO;
import com.vacinas.repository.UserRepository;
import com.vacinas.service.AssignRolesToUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class AssignRolesToUserServiceImpl implements AssignRolesToUserService {

    final UserRepository userRepository;

    @Override
    public UserModel execute(UserRoleDTO userRoleDTO) {
            Optional<UserModel> userExists = userRepository.findById(userRoleDTO.getId());
            List<RoleModel> roles;

            if (userExists.isEmpty()) {
                throw new DataIntegrityViolationException("Permissão já existente");
            }

            roles = userRoleDTO.getIdsRoles().stream().map(RoleModel::new).collect(Collectors.toList());


            UserModel userModel = userExists.get();
            userModel.setRoles(roles);

            userRepository.save(userModel);

            return userModel;

        }
    }

