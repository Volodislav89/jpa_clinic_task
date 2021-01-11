package com.spring.jpa_clinic_task.service;

import com.spring.jpa_clinic_task.model.Patient;
import com.spring.jpa_clinic_task.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findPatientById(Long patientId) throws Exception {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new Exception(String.format("No patient with id: %d was found.", patientId)));
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient updatePatient(Long patientId, Patient patient) throws Exception {
        Patient updatedPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new Exception(String.format("No patient with id: %d was found.", patientId)));
        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setLastName(patient.getLastName());
        updatedPatient.setMiddleName(patient.getMiddleName());
        updatedPatient.setPhoneNumber(patient.getPhoneNumber());
        return patientRepository.save(updatedPatient);
    }

    @Transactional
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }
}
