package com.clinicAnimal.system_vet_clinica.Web.dto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesResponseDTO {
    private Long rolCodigo;
    private String rolNombre;
    private int cantPersonal;
    private String descripcion;
}
