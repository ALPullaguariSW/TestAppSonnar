package com.citas.services;
import com.citas.model.entities.Consultorio;
import com.citas.repositories.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultorioServiceImp implements ConsultorioService {
    @Autowired
    private ConsultorioRepository consultorioRepository;
    @Override
    public List<Consultorio> findAll() {
        return (List<Consultorio>) consultorioRepository.findAll();
    }

    @Override
    public Consultorio save(Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }
    @Override
    public Optional<Consultorio> findById(Long id) {
        return consultorioRepository.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        consultorioRepository.deleteById(id);
    }
}