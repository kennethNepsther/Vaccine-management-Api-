package com.vacinas.service;

import com.vacinas.model.User;
import com.vacinas.model.dto.request.UserRoleDTO;

public interface AssignRolesToUserService {
    User execute(UserRoleDTO userRoleDTO);
}
