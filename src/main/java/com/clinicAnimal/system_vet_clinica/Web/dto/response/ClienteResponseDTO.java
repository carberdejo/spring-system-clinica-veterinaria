package com.clinicAnimal.system_vet_clinica.web.dto.response;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String direccion;
    private String email;
    private List<MascotaResponseDTO> mascotas;
}
