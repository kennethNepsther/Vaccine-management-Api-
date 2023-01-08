package com.vacinas.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public  class UserRoleDTO {
    @NotNull(message = "Deve informar o utilizador")
    private  Long id;
    @NotNull(message = "Deve informar pelo menos um perfil")
    private  List<Long> roleIdList;
}
