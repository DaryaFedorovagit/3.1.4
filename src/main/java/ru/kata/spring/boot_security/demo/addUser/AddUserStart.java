package ru.kata.spring.boot_security.demo.addUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class AddUserStart {
    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public AddUserStart(RoleRepository roleRepos, UserService userService) {
        this.roleRepository = roleRepos;
        this.userService = userService;
    }

    @PostConstruct
    private void initAddUserStart() {
        roleRepository.save(new Role(1L, "ROLE_ADMIN"));
        roleRepository.save(new Role(2L, "ROLE_USER"));

        List<Role> adminRole = roleRepository.findById(1L).stream().toList();
        List<Role> userRole = roleRepository.findById(2L).stream().toList();

        userService.saveUser(new User("admin@admin.ru", "admin", adminRole));
        userService.saveUser(new User("user@user.ru", "user", userRole));
    }
}