package com.clinicAnimal.system_vet_clinica.Web.dto;

import com.clinicAnimal.system_vet_clinica.Domain.Models.estado.EstadoPersonal;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalUpdateDTO {
    private EstadoPersonal estadoPersonal;
}
