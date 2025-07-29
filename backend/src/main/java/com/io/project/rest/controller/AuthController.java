package com.io.project.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.io.project.domain.entity.User;
import com.io.project.rest.dto.LoginRequestDTO;
import com.io.project.rest.dto.RegisterRequestDTO;
import com.io.project.rest.dto.ResponseDTO;
import com.io.project.configuration.security.TokenService;
import com.io.project.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name = "Autenticação", description = "Endpoints para login e gerenciamento de autenticação")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    
    @Operation(summary = "Autentica usuário e gera token JWT")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Registra novo usuário")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO body) {
        if (isEmailOrCpfRegistered(body.email(), body.cpf())) {
            return ResponseEntity.badRequest().body("E-mail ou CPF já cadastrado");
        }

        User newUser = createUserFromDto(body);
        repository.save(newUser);

        String token = tokenService.generateToken(newUser);
        return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
    }

    private boolean isEmailOrCpfRegistered(String email, String cpf) {
        return repository.findByEmail(email).isPresent() || repository.findByCPF(cpf).isPresent();
    }

    private User createUserFromDto(RegisterRequestDTO body) {
        return User.builder()
            .name(body.name())
            .email(body.email())
            .cpf(body.cpf())
            .password(passwordEncoder.encode(body.password()))
            .role(body.role())
            .build();
    }

}
