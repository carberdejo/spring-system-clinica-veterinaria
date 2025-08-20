package com.clinicAnimal.system_vet_clinica.Web.dto;

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
