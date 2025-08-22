package com.clinicAnimal.system_vet_clinica.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteUpdateDTO {
    private String telefono;
    private String direccion;
    private String email;
}
