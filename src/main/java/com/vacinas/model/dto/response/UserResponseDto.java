package com.vacinas.model.dto.response;

import com.vacinas.model.User;
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
   public UserResponseDto(User user) {
       this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
   }

   public static List<UserResponseDto> convertToList(List<User> users) {
       return users.stream().map(UserResponseDto::new).collect(Collectors.toList());
   }

}
