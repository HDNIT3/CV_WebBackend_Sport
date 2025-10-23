package com.example.demo.controller;

import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.response.data;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<data> register(@Valid @RequestBody RegisterRequest request) {
        try {
            userService.register(request.getUsername(), request.getPassword());
            return ResponseEntity.ok().body(new data("Success","Registered successfully",request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new data("Failure",e.getMessage(),null));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<data> login(@Valid @RequestBody RegisterRequest request) {
        try {
            Map<String, Object> response = userService.login(request.getUsername(), request.getPassword());
            return ResponseEntity.ok(new data("Success", "Log in successfully", response));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new data("Failure", e.getMessage(), null));
        }
    }
}
