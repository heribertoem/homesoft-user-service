package com.homeSoft.solutions.user_service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeviceMetadata {
    private String so;
    private String id;
    private String version;
    private String company;
}
