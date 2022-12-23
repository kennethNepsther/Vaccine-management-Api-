package com.vacinas.service;

import com.vacinas.model.User;
import com.vacinas.model.dto.UserRoleDTO;

public interface AssignRolesToUserService {
    User execute(UserRoleDTO userRoleDTO);
}
