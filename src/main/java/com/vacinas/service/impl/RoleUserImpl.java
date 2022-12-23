package com.vacinas.service.impl;

import com.vacinas.model.Role;
import com.vacinas.model.User;
import com.vacinas.model.dto.UserRoleDTO;
import com.vacinas.repository.UserRepository;
import com.vacinas.service.RoleService;
import com.vacinas.service.RoleUserService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RoleUserImpl implements RoleService {
    final UserRepository userRepository;


    @Override
    public Role create(Role role) {
        return null;
    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

