package com.citas.services;

import com.citas.model.entities.Medico;

import com.citas.repositories.MedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImp implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> findAll() {
        return (List<Medico>) medicoRepository.findAll();
    }

    @Override
    public Medico save(Medico estudiante) {
        return medicoRepository.save(estudiante);
    }

    @Override
    public Optional<Medico> findById(Long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }
}