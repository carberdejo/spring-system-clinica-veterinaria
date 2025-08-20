package com.clinicAnimal.system_vet_clinica.web.dto;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PersonalResponseDTO {
    private Long per_id;
    private String nombrePersonal;
    private String apellidoPersonal;
    private int edad;
    private String dni;
    private String email;
    private String telefono;
    private EstadoPersonal estadoPersonal;
    private String rolNombre;
}
