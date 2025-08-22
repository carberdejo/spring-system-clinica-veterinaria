package com.clinicAnimal.system_vet_clinica.web.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreasResponseDTO {
    private Long codigoArea;
    private String nomArea;
    private String descripcion;
}
