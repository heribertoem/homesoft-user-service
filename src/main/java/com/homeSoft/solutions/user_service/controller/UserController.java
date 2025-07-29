package com.homeSoft.solutions.user_service.controller;

import com.homeSoft.solutions.user_service.exception.InvalidCredentialsException;
import com.homeSoft.solutions.user_service.model.DeviceMetadata;
import com.homeSoft.solutions.user_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final AuthService authService;

    @PostMapping(value ="/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestParam String name,
                                   @RequestParam String password,
                                   @RequestBody DeviceMetadata deviceMetadata) {
        try {
            System.out.println("comienza::: ");
            String token = authService.login(name, password, deviceMetadata);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }

    @PostMapping(value = "/saludar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String saludar(){
        return  authService.saludar();
    }
}
