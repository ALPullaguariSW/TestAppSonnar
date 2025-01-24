package com.citas.model.dtos;

import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDTO {

    @NotNull(message = "El ID del paciente no puede ser nulo")
    private Long pacienteId;

    @NotNull(message = "El ID del médico no puede ser nulo")
    private Long medicoId;

    @NotNull(message = "El ID del consultorio no puede ser nulo")
    private Long consultorioId;

    @NotNull(message = "La fecha no puede ser nula")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @NotNull(message = "La hora no puede ser nula")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;

    // Constructor por defecto (necesario para la deserialización)
    public CitaDTO() {
    }

    // Getters y Setters
    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public Long getConsultorioId() {
        return consultorioId;
    }

    public void setConsultorioId(Long consultorioId) {
        this.consultorioId = consultorioId;
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