package com.example.SpringSecurityDemo.service;

import com.example.SpringSecurityDemo.dto.UserRegisterRequestDto;
import com.example.SpringSecurityDemo.dto.UserRegisterResponseDto;
import com.example.SpringSecurityDemo.entity.Role;
import com.example.SpringSecurityDemo.entity.User;
import com.example.SpringSecurityDemo.repository.RoleRepository;
import com.example.SpringSecurityDemo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public AuthService(UserRepository userRepository,
                        PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    public UserRegisterResponseDto registerUser(
            UserRegisterRequestDto registerRequestDto){
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());

        String encodedPass = passwordEncoder.encode(registerRequestDto.getPassword());

        user.setPassword(encodedPass);
        user.setEnabled(true);

        Role role = roleRepository.findByName("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();

        userRegisterResponseDto.setUsername(user.getUsername());
        userRegisterResponseDto.setMessage("User saved");

        return userRegisterResponseDto;

    }
}
