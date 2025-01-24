package com.citas.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "consultorios")
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Min(1) // Número del consultorio debe ser mayor o igual a 1
    private int numero;

    @Column(nullable = false)
    @NotNull
    @Min(1) // Piso debe ser mayor o igual a 1
    private int piso;

    // Constructor por defecto
    public Consultorio() {}

    // Constructor con parámetros
    public Consultorio(int numero, int piso) {
        this.numero = numero;
        this.piso = piso;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}
