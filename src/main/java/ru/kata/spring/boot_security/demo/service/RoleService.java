package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();

    Role getRoleByName(String name);

    void add(Role role);

    void deleteById(Long id);

    Role showUserById(Long id);

}