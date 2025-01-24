package com.citas.repositories;

import com.citas.model.entities.Consultorio;
import com.citas.model.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface ConsultorioRepository extends CrudRepository<Consultorio, Long> {
}
