package com.spring.jpa_clinic_task.repository;

import com.spring.jpa_clinic_task.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
