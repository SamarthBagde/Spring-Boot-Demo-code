package com.example.SpringSecurityDemo.service;

import com.example.SpringSecurityDemo.entity.CustomeUserDetails;
import com.example.SpringSecurityDemo.entity.User;
import com.example.SpringSecurityDemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeuserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomeuserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByusername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User Not Found"
                ));

        return new CustomeUserDetails(user);
    }
}
