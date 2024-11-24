package com.example.javasample.service;

import com.example.javasample.dto.LoginReq;
import com.example.javasample.dto.SignUpReq;
import com.example.javasample.entity.User;
import com.example.javasample.entity.UserRoleEnum;
import com.example.javasample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String MANAGER_TOKEN = "1234";

    @Transactional
    public void signUp(SignUpReq req) {
        String username = req.getUsername();
        String password = passwordEncoder.encode(req.getPassword());
        String token = req.getToken();
        UserRoleEnum role = req.getRole();

        if(userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임 입니다.");
        }

        // MANAGER 역할 검증
        if (role == UserRoleEnum.MANAGER) {
            if (!MANAGER_TOKEN.equals(req.getToken())) {
                throw new IllegalArgumentException("유효하지 않은 관리자 토큰입니다.");
            }
        }

        User user = new User(username, password, role);
        userRepository.save(user);
    }

    public void login(LoginReq req) {
        String username = req.getUsername();
        String password = req.getPassword();


    }
}
