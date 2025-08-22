package com.clinicAnimal.system_vet_clinica.web.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDTO {
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String direccion;
    private String email;
}
