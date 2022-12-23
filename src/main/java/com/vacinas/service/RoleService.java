package com.vacinas.service;

import com.vacinas.model.Role;

import java.util.List;

public interface RoleService {

    Role create(Role role);

    Role findById(Long id);

    List<Role> findAll();

    void delete(Long id);
}
