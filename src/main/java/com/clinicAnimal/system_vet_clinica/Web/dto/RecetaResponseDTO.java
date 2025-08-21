package com.clinicAnimal.system_vet_clinica.web.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecetaResponseDTO {
    private Long id;
    private LocalDateTime fechaEmision;
    private String indicaciones;
    private String medicamentos;
    private Long citaId;
    private String nombrePaciente;
}
