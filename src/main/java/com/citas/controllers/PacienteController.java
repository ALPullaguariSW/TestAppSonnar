package com.citas.controllers;

import com.citas.model.entities.Paciente;
import com.citas.services.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:5500")
public class PacienteController {

    @Autowired
    private PacienteService service;

    // Crear un nuevo paciente
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paciente));
    }

    // Listar todos los pacientes
    @GetMapping
    public List<Paciente> listar() {
        return service.findAll();
    }

    // Buscar un paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> pacienteOptional = service.findById(id);
        if (pacienteOptional.isPresent()) {
            return ResponseEntity.ok().body(pacienteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Editar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Paciente paciente, @PathVariable Long id) {
        Optional<Paciente> pacienteOptional = service.findById(id);
        if (pacienteOptional.isPresent()) {
            Paciente pacienteDB = pacienteOptional.get();
            pacienteDB.setNombre(paciente.getNombre());
            pacienteDB.setApellido(paciente.getApellido());
            pacienteDB.setEmail(paciente.getEmail());
            pacienteDB.setFechaNacimiento(paciente.getFechaNacimiento());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pacienteDB));
        }
        return ResponseEntity.notFound().build();
    }
}
