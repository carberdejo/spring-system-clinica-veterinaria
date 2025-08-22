package com.clinicAnimal.system_vet_clinica.web.dto;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PersonalResponseDTO {
    private Long perId;
    private String nombrePersonal;
    private String apellidoPersonal;
    private int edad;
    private String dni;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;
    private LocalTime fechaEntrada;
    private LocalTime fechaSalida;
    private EstadoPersonal estadoPersonal;
    private String rolNombre;
    private String nomArea;
}
