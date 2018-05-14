package com.simple.app;

import com.simple.app.entity.Role;
import com.simple.app.entity.User;
import com.simple.app.repository.RoleRepository;
import com.simple.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {
    private static final String DEFAULT_BASE_USERNAME = "admin";
    private static final String DEFAULT_BASE_PASS = "admin";
    private static final String DEFAULT_BASE_ROLES = "ADMIN,USER";

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataLoader(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {
        Optional<String> roles = Optional.ofNullable(System.getenv("APP_BASE_ROLES"));
        String[] defaultRoles = roles.orElse(DEFAULT_BASE_ROLES).split(",");
        Set<Role> allRoles = new HashSet<>();
        for(String roleName: defaultRoles){
            Role role = new Role();
            role.setName(roleName);
            allRoles.add(roleRepository.save(role));
        }
        User admin = new User();
        Optional<String> adminUserName = Optional.ofNullable(System.getenv("APP_BASE_USERNAME"));
        Optional<String> adminPassword = Optional.ofNullable(System.getenv("APP_BASE_PASS"));
        admin.setUsername(adminUserName.orElse(DEFAULT_BASE_USERNAME));
        admin.setPassword(bCryptPasswordEncoder.encode(adminPassword.orElse(DEFAULT_BASE_PASS)));
        admin.setRoles(allRoles);
        userRepository.save(admin);
    }
}
