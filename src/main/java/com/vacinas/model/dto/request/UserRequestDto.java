package com.vacinas.model.dto.request;

import com.vacinas.model.RoleModel;
import com.vacinas.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String name;
    private String username;
    private String password;
    private List<RoleModel> roleModels;

    public UserModel build(){
        return new UserModel()
                .setName(this.name)
                .setUsername(this.username)
                .setPassword(this.password)
                .setRoleModels(this.roleModels);
    }

}