package com.spring.jpa_clinic_task.service;

import com.spring.jpa_clinic_task.model.Doctor;
import com.spring.jpa_clinic_task.model.DoctorSimpleDTO;
import com.spring.jpa_clinic_task.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {
    private DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(Long doctorId) throws Exception {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new Exception(String.format("No doctor with id: %d was found.", doctorId)));
    }

    public String getDoctorsNameById(Long id) {
        return doctorRepository.getDoctorsNameById(id);
    }

    public List<Doctor> getDoctorByName(String name) {
        return doctorRepository.getDoctorByName(name);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<DoctorSimpleDTO> getDoctors() {
        return doctorRepository.getDoctors();
    }

    @Transactional
    public Doctor updateDoctor(Long doctorId, Doctor doctor) throws Exception {
            Doctor updatedDoctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new Exception(String.format("No doctor with id: %d was found.", doctorId)));
            updatedDoctor.setFirstName(doctor.getFirstName());
            updatedDoctor.setLastName(doctor.getLastName());
            updatedDoctor.setMiddleName(doctor.getMiddleName());
            updatedDoctor.setSpecialization(doctor.getSpecialization());
            return doctorRepository.save(updatedDoctor);
    }

    @Transactional
    public void deleteDoctorById(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
