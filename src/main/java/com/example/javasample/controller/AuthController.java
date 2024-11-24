package com.example.javasample.controller;

import com.example.javasample.dto.SignUpReq;
import com.example.javasample.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpReq req) {
        authService.signUp(req);
        return ResponseEntity.ok("회원가입에 성공하였습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Loginreq req) {
        authService.login(req);
        return ResponseEntity.ok("로그인에 성공하였습니다.");
    }

}
