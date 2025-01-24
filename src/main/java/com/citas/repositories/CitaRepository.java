package com.citas.repositories;

import com.citas.model.entities.Cita;
import com.citas.model.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface CitaRepository extends CrudRepository<Cita, Long> {
}
