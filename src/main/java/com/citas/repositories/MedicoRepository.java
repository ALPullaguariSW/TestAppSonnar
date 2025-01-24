package com.citas.repositories;

import com.citas.model.entities.Medico;
import com.citas.model.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends CrudRepository<Medico, Long> {
}
