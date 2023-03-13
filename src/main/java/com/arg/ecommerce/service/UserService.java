package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.User;
import com.arg.ecommerce.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> listUsers();

    void save(UserDto userDto);

    void delete(UserDto userDto);

    User findUserByEmail(String email);
}
