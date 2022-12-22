package com.vacinas.service;

import com.vacinas.model.User;
import com.vacinas.model.dto.UserRoleDTO;

import java.util.List;

public interface RoleUserService {

    User execute(UserRoleDTO userRoleDTO);
}
