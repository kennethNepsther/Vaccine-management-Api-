package com.vacinas.service;

import com.vacinas.model.UserModel;
import com.vacinas.model.dto.request.UserRoleDTO;

public interface AssignRolesToUserService {
    UserModel execute(UserRoleDTO userRoleDTO);
}
