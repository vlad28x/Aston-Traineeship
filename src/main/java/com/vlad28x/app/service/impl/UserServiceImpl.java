package com.vlad28x.app.service.impl;

import com.vlad28x.app.dto.UserRequestDto;
import com.vlad28x.app.dto.UserResponseDto;
import com.vlad28x.app.entity.User;
import com.vlad28x.app.exception.NotFoundException;
import com.vlad28x.app.repository.impl.UserRepositoryImpl;
import com.vlad28x.app.service.UserService;
import com.vlad28x.app.util.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto getById(Long id) {
        return UserMapper.userToUserResponseDto(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with ID %s not found", id))));
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::userToUserResponseDto).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto create(UserRequestDto newUser) {
        return UserMapper.userToUserResponseDto(userRepository.save(UserMapper.userRequestDtoToUser(newUser)));
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto newUser) {
        User user = UserMapper.userRequestDtoToUser(newUser);
        user.setId(id);
        return UserMapper.userToUserResponseDto(userRepository.update(UserMapper.userRequestDtoToUser(newUser)));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
