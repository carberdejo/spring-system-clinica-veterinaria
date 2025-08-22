package com.clinicAnimal.system_vet_clinica.web.dto;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import lombok.*;

import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalUpdateDTO {
    private EstadoPersonal estadoPersonal;
    private LocalTime fechaEntrada;
    private LocalTime fechaSalida;
    private String email;
    private String telefono;
}
