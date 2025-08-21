package com.clinicAnimal.system_vet_clinica.domain.model;

import com.clinicAnimal.system_vet_clinica.domain.model.Estados.EstadoPersonal;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private Long perId;
    @Column(name = "NombrePersonal")
    private String nombrePersonal;
    @Column(name = "ApellidoPersonal")
    private String apellidoPersonal;
    @Column(name = "Edad")
    private int edad;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;
    @Column(name="fechaEntrada")
    private LocalTime fechaEntrada;
    @Column(name="fechaSalida")
    private LocalTime fechaSalida;
    @Column(name="Estado")
    @Enumerated (EnumType.STRING)
    private EstadoPersonal estadoPersonal;
    @ManyToOne
    @JoinColumn(name = "rolCodigo")
    private Roles roles;
    @ManyToOne
    @JoinColumn(name="codigoArea")
    private Areas areas;

}
