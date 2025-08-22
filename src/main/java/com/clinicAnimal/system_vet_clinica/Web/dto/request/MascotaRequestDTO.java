package com.clinicAnimal.system_vet_clinica.web.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MascotaRequestDTO {
    private String nombre;
    private String raza;
    private int edad;
    private String sexo;
    private Long clienteId;
}
