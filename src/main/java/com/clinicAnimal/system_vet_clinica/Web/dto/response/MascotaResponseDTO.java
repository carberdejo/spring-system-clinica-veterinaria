package com.clinicAnimal.system_vet_clinica.web.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MascotaResponseDTO {
    private Long id;
    private String nombre;
    private String raza;
    private int edad;
    private String sexo;
    private Long clienteId;
}
