package com.clinicAnimal.system_vet_clinica.web.dto.request;


import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaRequestDTO {
    private LocalDateTime fechaHora;
    private Long mascotaId;
}