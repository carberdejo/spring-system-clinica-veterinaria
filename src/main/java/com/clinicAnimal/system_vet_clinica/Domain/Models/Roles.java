package com.clinicAnimal.system_vet_clinica.Domain.Models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Codigo_Rol")
    private Long rolCodigo;
    private String rolNombre;
    private int cantPersonal;
    private String descripcion;
    @OneToMany(mappedBy = "roles",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Personal> personalList;

}
