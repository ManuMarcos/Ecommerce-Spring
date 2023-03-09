package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();

    public void save(User user);

    public void delete(User user);

    public User findUserById(User user);
}
