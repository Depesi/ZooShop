package ua.bg.zooshop.DTO;

import lombok.Builder;

import java.util.List;

@Builder
public class LoginResponse {
    private String jwt;
    private String username;
    private List<String> roles;
}
