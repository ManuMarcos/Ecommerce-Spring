package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.UserDao;
import com.arg.ecommerce.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(User user) {
        return userDao.findById(user.getIdUser()).orElse(null);
    }
}
