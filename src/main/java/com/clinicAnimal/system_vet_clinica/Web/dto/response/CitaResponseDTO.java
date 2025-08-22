package com.clinicAnimal.system_vet_clinica.web.dto.response;


import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoCita;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaResponseDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private EstadoCita estado;
    private Long mascotaId;
    private String nombreMascota;
    private boolean tieneReceta;
}
