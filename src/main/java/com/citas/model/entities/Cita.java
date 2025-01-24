package com.citas.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    @NotNull

    private Paciente paciente;

    // Relación con Médico
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @NotNull

    private Medico medico;

    // Relación con Consultorio
    @ManyToOne
    @JoinColumn(name = "consultorio_id", nullable = false)
    @NotNull
    private Consultorio consultorio;

    // Fecha de la cita
    @Column(nullable = false)
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    // Hora de la cita
    @Column(nullable = false)
    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;

    // Constructor por defecto
    public Cita() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
