package com.citas.repositories;

import com.citas.model.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
}
