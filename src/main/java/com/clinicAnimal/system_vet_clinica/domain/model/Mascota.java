package com.clinicAnimal.system_vet_clinica.domain.model;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "Mascota")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="raza")
    private String raza;
    @Column(name="edad")
    private int edad;
    @Column(name="sexo")
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(mappedBy = "mascota")
    private HistoriaClinica historiaClinica;
}
