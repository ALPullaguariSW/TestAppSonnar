package com.citas.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 255, message = "El nombre debe tener entre 2 y 255 caracteres")
    private String nombre;

    @Column(nullable = false, length = 255)
    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 2, max = 255, message = "El apellido debe tener entre 2 y 255 caracteres")
    private String apellido;

    @Column(nullable = false, length = 100)
    @NotNull(message = "La especialidad no puede ser nula")
    @Size(min = 2, max = 100, message = "La especialidad debe tener entre 2 y 100 caracteres")
    private String especialidad;

    // Constructor por defecto
    public Medico() {}

    // Constructor con parámetros
    public Medico(String nombre, String apellido, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
