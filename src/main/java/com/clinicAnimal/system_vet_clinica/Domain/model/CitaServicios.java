package com.clinicAnimal.system_vet_clinica.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cita_servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaServicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cit_servi")
    private Long id;
    private Integer cantidad;
    private double precioUnitario;
    private double subTotal;
    @ManyToOne
    @JoinColumn(name = "id")
    private Cita cita;
    @ManyToOne
    @JoinColumn(name = "cod_servicio")
    private Servicios servicios;
}
