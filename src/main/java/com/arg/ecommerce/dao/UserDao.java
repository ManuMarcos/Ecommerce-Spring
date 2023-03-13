package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

}
