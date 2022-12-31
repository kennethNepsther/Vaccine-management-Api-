package com.vacinas.model.mappers;

import com.vacinas.model.UserModel;
import com.vacinas.model.dto.request.UserRequestDto;
import com.vacinas.model.dto.response.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public interface UserMapper {

     ModelMapper modelMapper = new ModelMapper();

    private UserRequestDto convertEntityToDto(UserModel userModel){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        UserRequestDto userRequestDto;
        userRequestDto = modelMapper.map(userModel, UserRequestDto.class);
        return userRequestDto;
    }

    private UserResponseDto convertEntityToResponseDto(UserModel userModel){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        UserResponseDto userResponseDto;
        userResponseDto = modelMapper.map(userModel, UserResponseDto.class);
        return userResponseDto;
    }
}
