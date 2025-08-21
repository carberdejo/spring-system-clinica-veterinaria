package com.clinicAnimal.system_vet_clinica.domain.model;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoCita;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "cita")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoCita estado;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
    private Receta receta;
}
