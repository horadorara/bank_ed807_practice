package com.example.bank.services;

import com.example.bank.configurations.MyUserDetails;
import com.example.bank.entities.Users;
import com.example.bank.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByName(name);
        return user.map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException(name + "This username it not exists"));
    }
}
