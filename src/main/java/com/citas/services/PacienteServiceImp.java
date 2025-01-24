package com.citas.services;

import com.citas.model.entities.Paciente;
import com.citas.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImp implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAll() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Override
    public Paciente save(Paciente estudiante) {
        return pacienteRepository.save(estudiante);
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }
}