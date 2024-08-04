package com.example.bank.utils;

import com.example.bank.entities.Users;
import com.example.bank.enums.Role;
import com.example.bank.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtils implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
        if(userRepository.findByName("user").isEmpty()) {
            Users user1 = new Users();
            user1.setName("user");
            user1.setPassword((encoder.encode("user")));
            user1.setRole(Role.ROLE_USER);

            userRepository.save(user1);
        }else {
            System.out.println("User");
        }
        if(userRepository.findByName("admin").isEmpty()) {
            Users admin = new Users();
            admin.setName("admin");
            admin.setPassword(encoder.encode("admin"));
            admin.setRole(Role.ROLE_ADMIN);

            userRepository.save(admin);
        }else {
            System.out.println("admin");
        }
    }
}
