package com.clinicAnimal.system_vet_clinica.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MascotaUpdateDTO {
    private String nombre;
    private String raza;
    private int edad;
    private String sexo;
}
