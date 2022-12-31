package com.vacinas.service;

import com.vacinas.model.RoleModel;

import java.util.List;

public interface RoleService {

    RoleModel create(RoleModel roleModel);

    RoleModel findById(Long id);

    List<RoleModel> findAll();

    void delete(Long id);
}
