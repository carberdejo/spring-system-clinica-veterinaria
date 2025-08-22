package com.clinicAnimal.system_vet_clinica.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioRequestDTO {
    private String nombre;
    private String descripcion;
    private Integer duracion;
    private double precio;
    private  Integer idArea;
}
