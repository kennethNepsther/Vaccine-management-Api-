package com.vacinas.model.mappers;

import com.vacinas.model.User;
import com.vacinas.model.dto.request.UserRequestDto;
import com.vacinas.model.dto.response.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public interface UserMapper {

     ModelMapper modelMapper = new ModelMapper();

    private UserRequestDto convertEntityToDto(User user){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        UserRequestDto userRequestDto;
        userRequestDto = modelMapper.map(user, UserRequestDto.class);
        return userRequestDto;
    }

    private UserResponseDto convertEntityToResponseDto(User user){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        UserResponseDto userResponseDto;
        userResponseDto = modelMapper.map(user, UserResponseDto.class);
        return userResponseDto;
    }
}
