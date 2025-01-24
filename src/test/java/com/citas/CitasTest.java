package com.citas;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


import com.citas.model.entities.Paciente;
import com.citas.model.entities.Medico;
import com.citas.model.entities.Consultorio;
import com.citas.model.dtos.CitaDTO;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class CitasTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCrearCitaConRelaciones() {

        Paciente paciente = new Paciente();
        paciente.setNombre("Axel");
        paciente.setApellido("asfgsd");
        paciente.setEmail("axelasd@espe.ec");
        paciente.setFechaNacimiento(LocalDate.parse("1997-07-31"));
        ResponseEntity<Paciente> pacienteResponse = restTemplate.postForEntity("/api/pacientes", paciente, Paciente.class);
        assertNotNull(pacienteResponse.getBody());

        // Crear un médico mediante el endpoint REST
        Medico medico = new Medico();
        medico.setNombre("sR");
        medico.setApellido("cOMINO");
        medico.setEspecialidad("Cardiologo");
        ResponseEntity<Medico> medicoResponse = restTemplate.postForEntity("/api/medicos", medico, Medico.class);
        assertNotNull(medicoResponse.getBody());

        // Crear un consultorio mediante el endpoint REST
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(101);
        consultorio.setPiso(1);
        ResponseEntity<Consultorio> consultorioResponse = restTemplate.postForEntity("/api/consultorios", consultorio, Consultorio.class);
        assertNotNull(consultorioResponse.getBody());

        // Crear una cita mediante el endpoint REST
        CitaDTO cita = new CitaDTO();
        cita.setFecha(LocalDate.parse("2025-05-27"));
        cita.setHora(LocalTime.parse("10:30"));
        cita.setConsultorioId(consultorioResponse.getBody().getId());
        cita.setMedicoId(medicoResponse.getBody().getId());
        cita.setPacienteId(pacienteResponse.getBody().getId());

        ResponseEntity<CitaDTO> citaResponse = restTemplate.postForEntity("/api/citas", cita, CitaDTO.class);
        assertNotNull(citaResponse.getBody());

        // Verificar que la cita tiene un paciente y un médico asociados
        assertTrue(citaResponse.getBody().getPacienteId() == pacienteResponse.getBody().getId());
        assertTrue(citaResponse.getBody().getMedicoId() == medicoResponse.getBody().getId());
    }
}
