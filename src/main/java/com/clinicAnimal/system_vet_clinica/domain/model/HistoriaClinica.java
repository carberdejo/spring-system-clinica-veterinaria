package com.clinicAnimal.system_vet_clinica.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaRegistro;

    @Column(name ="diagnostico")
    private String diagnostico;

    @Column(name ="diagnostico")
    private String tratamiento;

    @OneToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;


//    @ManyToOne
//    @JoinColumn(name = "personal_id")
//    private Personal personal;

    @OneToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;
}