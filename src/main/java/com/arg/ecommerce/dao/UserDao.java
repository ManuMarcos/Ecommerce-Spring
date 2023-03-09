package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {


}
