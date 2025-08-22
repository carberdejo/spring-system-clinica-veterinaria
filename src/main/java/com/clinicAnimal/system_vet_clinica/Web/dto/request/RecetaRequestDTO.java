package com.clinicAnimal.system_vet_clinica.web.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecetaRequestDTO {
    private LocalDateTime fechaEmision;
    private String indicaciones;
    private String medicamentos;
    private Long citaId;
}
