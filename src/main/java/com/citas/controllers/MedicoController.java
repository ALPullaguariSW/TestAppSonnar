package com.citas.controllers;

import com.citas.model.entities.Medico;
import com.citas.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "http://localhost:5500")
public class MedicoController {

    @Autowired
    private MedicoService service;

    // Crear un nuevo médico
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Medico medico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(medico));
    }

    // Listar todos los médicos
    @GetMapping
    public List<Medico> listar() {
        return service.findAll();
    }

    // Buscar un médico por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Medico> medicoOptional = service.findById(id);
        if (medicoOptional.isPresent()) {
            return ResponseEntity.ok().body(medicoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Editar un médico existente
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Medico medico, @PathVariable Long id) {
        Optional<Medico> medicoOptional = service.findById(id);
        if (medicoOptional.isPresent()) {
            Medico medicoDB = medicoOptional.get();
            medicoDB.setNombre(medico.getNombre());
            medicoDB.setApellido(medico.getApellido());
            medicoDB.setEspecialidad(medico.getEspecialidad());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(medicoDB));
        }
        return ResponseEntity.notFound().build();
    }
}
