package ua.bg.zooshop.security;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.DTO.LoginRequest;
import ua.bg.zooshop.DTO.LoginResponse;
import ua.bg.zooshop.DTO.SignUpRequest;
import ua.bg.zooshop.config.security.JwtUtils;
import ua.bg.zooshop.entity.Role;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.repository.IRoleRepository;
import ua.bg.zooshop.repository.IUserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IRoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;

    public LoginResponse authenticateRequest(LoginRequest request) {

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        var jwt = jwtUtils.generateJwtToken(auth);
        var details = (UserDetailsImpl) auth.getPrincipal();
        var roles = details.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return LoginResponse.builder()
                .jwt(jwt)
                .username(details.getUsername())
                .roles(roles)
                .build();
    }

    public String signUpUser(SignUpRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username " + request.getUsername() + " already exist");
        }

        var user = User.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .roles(new HashSet<>(Arrays.asList(mapStringToRole("ROLE_USER"))))
                .phone(request.getPhone())
                .firstName(request.getFirstName())
                .surrName(request.getSurrName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        userRepository.save(user);

        return "User was successfully created";
    }

    private Role mapStringToRole(String roleString) {
        return roleRepository.findByName(Role.ERole.valueOf(roleString))
                .orElseThrow(() -> new IllegalArgumentException("Wrong name of role" + roleString));
    }
}
