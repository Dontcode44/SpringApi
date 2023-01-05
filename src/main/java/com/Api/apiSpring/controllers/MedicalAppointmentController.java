package com.Api.apiSpring.controllers;

import com.Api.apiSpring.models.MedicalAppointment;
import com.Api.apiSpring.services.MedicalAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agendar")
@RequiredArgsConstructor
public class MedicalAppointmentController {
    private final MedicalAppointmentService medicalAppointmentService;

    @PostMapping
    public ResponseEntity createMedical(@RequestBody MedicalAppointment medicalAppointment) {
        return new ResponseEntity(medicalAppointmentService.createMedical(medicalAppointment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneMedical(@PathVariable() Long id) {
        return new ResponseEntity(medicalAppointmentService.getOneMedical(id), HttpStatus.OK);
    }
}
