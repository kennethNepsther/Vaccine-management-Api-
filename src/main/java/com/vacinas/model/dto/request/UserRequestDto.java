package com.vacinas.model.dto.request;

import com.vacinas.model.RoleModel;
import com.vacinas.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private Long id;
    @NotBlank
    @Size(min = 3, max = 20)
    @NotNull(message = "O nome é obrigatório")
    private String name;

    @NotBlank
    @Size(min = 4, max = 8)
    @NotNull(message = "O nome do utilizador é obrigatório")
    private String username;
    @NotBlank
    @Size(min = 5)
    @NotNull(message = "A senha é obrigatória")
    private String password;
    private List<RoleModel> roles;

    public UserModel build() {
        return new UserModel()
                .setName(this.name)
                .setUsername(this.username)
                .setPassword(this.password)
                .setRoles(this.roles);
    }


    public static void update(UserRequestDto userDTO, UserModel user){
        BeanUtils.copyProperties(userDTO, user);
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());

    }




}
