package ua.bg.zooshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {
    private String jwt;
    private String username;
    private List<String> roles;
}
