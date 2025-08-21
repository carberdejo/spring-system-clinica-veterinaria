package com.clinicAnimal.system_vet_clinica.web.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesRequestDTO {
    private String rolNombre;
    private String descripcion;

}
