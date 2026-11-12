package com.example.SpringSecurityDemo.controller;

import com.example.SpringSecurityDemo.dto.UserRegisterRequestDto;
import com.example.SpringSecurityDemo.dto.UserRegisterResponseDto;
import com.example.SpringSecurityDemo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto registerRequestDto){
        UserRegisterResponseDto userRegisterResponseDto = authService.registerUser(registerRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }


}
