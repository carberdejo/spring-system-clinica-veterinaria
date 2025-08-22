package com.clinicAnimal.system_vet_clinica.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_servi-cita")
    private Long id;
    private Integer cantidad;
    private double precioBase;
    private  double subTotal;
    @ManyToOne
    @JoinColumn(name="codigoArea")
    private Cita cita;
    @ManyToOne
    @JoinColumn(name="cod_servicio")
    private Servicios servicios;
}
