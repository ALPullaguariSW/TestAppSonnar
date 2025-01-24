package com.citas.services;


import com.citas.model.entities.Paciente;


import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<Paciente> findAll();
    Paciente save(Paciente paciente);
    Optional<Paciente> findById(Long id);
    void deleteById(Long id);

}
