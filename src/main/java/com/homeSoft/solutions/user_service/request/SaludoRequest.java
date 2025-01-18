package com.homeSoft.solutions.user_service.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SaludoRequest {

    private String nombre;
    private String apellido;
    private String genero;

}
