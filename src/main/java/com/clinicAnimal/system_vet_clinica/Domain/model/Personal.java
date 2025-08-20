package com.clinicAnimal.system_vet_clinica.domain.model;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Personal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long per_id;
    private String nombrePersonal;
    private String apellidoPersonal;
    private int edad;
    private String dni;
    private String email;
    private String telefono;
    @Enumerated (EnumType.STRING)
    private EstadoPersonal estadoPersonal;
    @ManyToOne
    @JoinColumn(name = "rolCodigo")
    private Roles roles;

}
