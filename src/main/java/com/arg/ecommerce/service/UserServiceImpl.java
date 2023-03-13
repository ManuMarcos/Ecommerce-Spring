package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.RoleDao;
import com.arg.ecommerce.dao.ShoppingSessionDao;
import com.arg.ecommerce.dao.UserDao;
import com.arg.ecommerce.domain.Role;
import com.arg.ecommerce.domain.ShoppingSession;
import com.arg.ecommerce.domain.User;
import com.arg.ecommerce.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{

   private UserDao userDao;
   private RoleDao roleDao;
   private PasswordEncoder passwordEncoder;

   @Autowired
   private ShoppingSessionDao shoppingSessionDao;

   private static final String DEFAULT_ROLE = "ROLE_ADMIN";

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder
    ) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> listUsers() {
        List<User> users = userDao.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        //Encrypt the password using Spring Security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        //Se crea un usuario con el DEFAULT_ROLE
        Role role = roleDao.findRoleByName(DEFAULT_ROLE);
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));

        userDao.save(user);
        this.createShoppingCart(user);
    }


    @Transactional
    @Override
    public void delete(UserDto userDto) {
        User user = this.findUserByEmail(userDto.getEmail());
        userDao.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName(DEFAULT_ROLE);
        return roleDao.save(role);
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto =  new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private void createShoppingCart(User user){
        ShoppingSession shoppingSession = new ShoppingSession();
        shoppingSession.setUser(user);
        shoppingSessionDao.save(shoppingSession);
    }





}
