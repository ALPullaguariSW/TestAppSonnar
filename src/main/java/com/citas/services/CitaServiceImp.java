package com.citas.services;
import com.citas.model.entities.Cita;
import com.citas.repositories.CitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImp implements CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Override
    public List<Cita> findAll() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public Cita save(Cita consultorio) {
        return citaRepository.save(consultorio);
    }
    @Override
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }
}