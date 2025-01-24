package com.citas.controllers;

import com.citas.model.entities.Consultorio;
import com.citas.services.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultorios")
@CrossOrigin(origins = "http://localhost:5500")
public class ConsultorioController {

    @Autowired
    private ConsultorioService service;

    // Crear un nuevo consultorio
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Consultorio consultorio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(consultorio));
    }

    // Listar todos los consultorios
    @GetMapping
    public List<Consultorio> listar() {
        return service.findAll();
    }

    // Buscar un consultorio por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Consultorio> consultorioOptional = service.findById(id);
        if (consultorioOptional.isPresent()) {
            return ResponseEntity.ok().body(consultorioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Editar un consultorio existente
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Consultorio consultorio, @PathVariable Long id) {
        Optional<Consultorio> consultorioOptional = service.findById(id);
        if (consultorioOptional.isPresent()) {
            Consultorio consultorioDB = consultorioOptional.get();
            consultorioDB.setNumero(consultorio.getNumero());
            consultorioDB.setPiso(consultorio.getPiso());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(consultorioDB));
        }
        return ResponseEntity.notFound().build();
    }
}
