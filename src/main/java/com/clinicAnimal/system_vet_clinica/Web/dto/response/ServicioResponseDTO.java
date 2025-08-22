package com.clinicAnimal.system_vet_clinica.web.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer duracion;
    private double precio;
    private Long idArea;
    private String nomArea;
}
