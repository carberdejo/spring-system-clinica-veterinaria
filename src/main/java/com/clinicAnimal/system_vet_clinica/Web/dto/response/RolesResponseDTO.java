package com.clinicAnimal.system_vet_clinica.web.dto.response;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesResponseDTO {
    private Long rolCodigo;
    private String rolNombre;
    private String descripcion;
}
