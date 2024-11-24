package com.example.javasample.dto;

import com.example.javasample.entity.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpReq {

    private String username;

    private String password;

    private UserRoleEnum role;

    private String token;
}
