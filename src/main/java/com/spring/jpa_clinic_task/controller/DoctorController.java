package com.spring.jpa_clinic_task.controller;

import com.spring.jpa_clinic_task.model.Doctor;
import com.spring.jpa_clinic_task.model.DoctorSimpleDTO;
import com.spring.jpa_clinic_task.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> findAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @GetMapping("/{doctorId}")
    public Doctor findDoctorById(@PathVariable Long doctorId) throws Exception {
        return doctorService.findDoctorById(doctorId);
    }

    @GetMapping("/name/{id}")
    public String getDoctorsNameById(@PathVariable Long id) {
        return doctorService.getDoctorsNameById(id);
    }

    @GetMapping("by/name/{name}")
    public List<Doctor> getDoctorByName(@PathVariable String name) {
        return doctorService.getDoctorByName(name);
    }

    @GetMapping("/simple")
    public List<DoctorSimpleDTO> getDoctors() {
        return doctorService.getDoctors();
    }

    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{doctorId}")
    public Doctor updateDoctor(@PathVariable Long doctorId, @RequestBody Doctor doctor) throws Exception {
        return doctorService.updateDoctor(doctorId, doctor);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable Long doctorId) {
        doctorService.deleteDoctorById(doctorId);
    }
}
