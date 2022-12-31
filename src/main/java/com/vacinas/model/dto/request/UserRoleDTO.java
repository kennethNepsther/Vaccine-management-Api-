package com.vacinas.model.dto.request;

import lombok.Data;

import java.util.List;
@Data
public  class UserRoleDTO {

    private  Long id;

    private  List<Long> idsRoles;
}
