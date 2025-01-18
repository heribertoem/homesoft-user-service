package com.homeSoft.solutions.user_service.model;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
public class Users {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
}
