package com.io.project.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.ResponseEntity;

import com.io.project.domain.entity.User;
import com.io.project.rest.dto.RegisterRequestDTO;
import com.io.project.rest.dto.PasswordChangeDTO;
import com.io.project.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;

import jakarta.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> getAllUser() {
        return service.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/cpf/{cpf}")
    public User getUserByCPF(@PathVariable String cpf) {
        return service.findByCPF(cpf);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public User postUser(@RequestBody @Valid RegisterRequestDTO dto) {
        return service.save(dto);
    } 
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/change-password")
    @ResponseStatus(NO_CONTENT)
    public void changePassword(@RequestBody PasswordChangeDTO dto, @AuthenticationPrincipal User user) {
        service.changePassword(user.getId(), dto);
    }

}
