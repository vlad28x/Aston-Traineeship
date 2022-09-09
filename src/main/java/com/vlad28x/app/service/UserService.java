package com.vlad28x.app.service;

import com.vlad28x.app.dto.UserRequestDto;
import com.vlad28x.app.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto getById(Long id);

    List<UserResponseDto> getAll();

    UserResponseDto create(UserRequestDto newUser);

    UserResponseDto update(Long id, UserRequestDto newUser);

    void delete(Long id);

}
