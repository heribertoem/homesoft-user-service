package com.homeSoft.solutions.user_service.service;

import com.homeSoft.solutions.user_service.model.DeviceMetadata;

public interface AuthService {
    public String login(String username, String password, DeviceMetadata deviceMetadata);
    public String saludar();
}
