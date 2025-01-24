package com.citas.services;


import com.citas.model.entities.Consultorio;

import java.util.List;
import java.util.Optional;

public interface ConsultorioService {
    List<Consultorio> findAll();
    Consultorio save(Consultorio consultorio);
    Optional<Consultorio> findById(Long id);
    void deleteById(Long id);

}
