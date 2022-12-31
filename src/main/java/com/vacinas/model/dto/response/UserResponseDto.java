package com.vacinas.model.dto.response;

import com.vacinas.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String username;
   public UserResponseDto(UserModel userModel) {
       this.id = userModel.getId();
        this.name = userModel.getName();
        this.username = userModel.getUsername();
   }

   public static List<UserResponseDto> convertToList(List<UserModel> userModels) {
       return userModels.stream().map(UserResponseDto::new).collect(Collectors.toList());
   }

}
