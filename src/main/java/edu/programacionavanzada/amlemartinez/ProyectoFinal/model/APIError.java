package edu.programacionavanzada.amlemartinez.ProyectoFinal.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class APIError {

    private int status;
    private String message;
}