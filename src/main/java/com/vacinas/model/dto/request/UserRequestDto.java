package com.vacinas.model.dto.request;

import com.vacinas.model.Role;
import com.vacinas.model.User;
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
    private List<Role> roles;

    public User build(){
        return new User()
                .setName(this.name)
                .setUsername(this.username)
                .setPassword(this.password)
                .setRoles(this.roles);
    }

}
