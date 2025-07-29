package com.homeSoft.solutions.user_service.service.impl;

import com.homeSoft.solutions.user_service.exception.InvalidCredentialsException;
import com.homeSoft.solutions.user_service.model.DeviceMetadata;
import com.homeSoft.solutions.user_service.model.Users;
import com.homeSoft.solutions.user_service.repository.UserRepository;
import com.homeSoft.solutions.user_service.service.AuthService;
import com.homeSoft.solutions.user_service.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public String login(String username, String password, DeviceMetadata deviceMetadata) {
        System.out.println("login::: ");
        Users user = userRepository.findByName(username)
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return jwtTokenProvider.generateToken(username, deviceMetadata);
    }

    @Override
    public String saludar() {
        return "Hola soy goku";
    }
}
