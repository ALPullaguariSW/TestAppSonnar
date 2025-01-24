package com.citas.services;


import com.citas.model.entities.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {
    List<Cita> findAll();
    Cita save(Cita cita);
    Optional<Cita> findById(Long id);
    void deleteById(Long id);

}
