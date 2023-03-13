package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);
}
