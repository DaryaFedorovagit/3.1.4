package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allUsers();

    User findById(Long id);

    void addUser(User user);

    void updateUser(User user);

    User findByEmail(String username);

    void removeUser(Long id);

    List<Role> roleList();

    @Override
    UserDetails loadUserByUsername(String username);
}