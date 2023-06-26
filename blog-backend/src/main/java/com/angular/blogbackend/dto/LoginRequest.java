package com.angular.blogbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String UserName;
    private String password;

}
