package com.spring.jpa_clinic_task.controller;

import com.spring.jpa_clinic_task.model.Patient;
import com.spring.jpa_clinic_task.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;

    @GetMapping
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping("/{patientId}")
    public Patient findPatientById(@PathVariable Long patientId) throws Exception {
        return patientService.findPatientById(patientId);
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable Long patientId, @RequestBody Patient patient) throws Exception {
        return patientService.updatePatient(patientId, patient);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
    }
}
