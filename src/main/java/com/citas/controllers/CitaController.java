package com.citas.controllers;

import com.citas.model.dtos.CitaDTO;
import com.citas.model.entities.Cita;
import com.citas.model.entities.Paciente;
import com.citas.model.entities.Medico;
import com.citas.model.entities.Consultorio;
import com.citas.services.CitaService;
import com.citas.services.PacienteService;
import com.citas.services.MedicoService;
import com.citas.services.ConsultorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "http://localhost:5500")
public class CitaController {

    @Autowired
    private CitaService service;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ConsultorioService consultorioService;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CitaDTO citaDTO) {
        try {
            // 1. Obtener las entidades relacionadas desde la base de datos
            Paciente paciente = pacienteService.findById(citaDTO.getPacienteId())
                    .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
            Medico medico = medicoService.findById(citaDTO.getMedicoId())
                    .orElseThrow(() -> new IllegalArgumentException("Medico no encontrado"));
            Consultorio consultorio = consultorioService.findById(citaDTO.getConsultorioId())
                    .orElseThrow(() -> new IllegalArgumentException("Consultorio no encontrado"));

            // 2. Crear la entidad Cita
            Cita nuevaCita = new Cita();
            nuevaCita.setPaciente(paciente);
            nuevaCita.setMedico(medico);
            nuevaCita.setConsultorio(consultorio);
            nuevaCita.setFecha(citaDTO.getFecha());
            nuevaCita.setHora(citaDTO.getHora());

            // 3. Guardar la cita en la base de datos
            nuevaCita = service.save(nuevaCita);

            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita); // Devuelve la Cita creada
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); // Devuelve 400 Bad Request si no se encuentran las entidades
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la cita: " + e.getMessage());
        }
    }

    // Listar todas las citas
    @GetMapping
    public ResponseEntity<List<Cita>> listar() {
        List<Cita> citas = service.findAll();
        return ResponseEntity.ok(citas);
    }

    // Buscar cita por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Cita> citaOptional = service.findById(id);
        if (citaOptional.isPresent()) {
            return ResponseEntity.ok(citaOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cita no encontrada con ID: " + id);
    }

    // Editar una cita existente
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Cita cita, @PathVariable Long id) {
        Optional<Cita> citaOptional = service.findById(id);
        if (citaOptional.isPresent()) {
            Cita citaDB = citaOptional.get();

            citaDB.setConsultorio(cita.getConsultorio());
            citaDB.setFecha(cita.getFecha());
            citaDB.setHora(cita.getHora());
            citaDB.setMedico(cita.getMedico());
            citaDB.setPaciente(cita.getPaciente());

            try {
                Cita citaActualizada = service.save(citaDB);
                return ResponseEntity.ok(citaActualizada);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al actualizar la cita: " + e.getMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cita no encontrada con ID: " + id);
    }
}