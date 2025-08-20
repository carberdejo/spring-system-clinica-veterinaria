package com.clinicAnimal.system_vet_clinica.web.dto;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalUpdateDTO {
    private EstadoPersonal estadoPersonal;
}
