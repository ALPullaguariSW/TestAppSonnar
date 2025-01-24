package com.citas.services;


import com.citas.model.entities.Medico;


import java.util.List;
import java.util.Optional;

public interface MedicoService {
    List<Medico> findAll();
    Medico save(Medico medico);
    Optional<Medico> findById(Long id);
    void deleteById(Long id);

}
