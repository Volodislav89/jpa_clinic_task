package com.spring.jpa_clinic_task.repository;

import com.spring.jpa_clinic_task.model.Doctor;
import com.spring.jpa_clinic_task.model.DoctorSimpleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "select * from function1(:id) as text", nativeQuery = true)
    String getDoctorsNameById(@Param("id") Long id);

    @Query(value = "select * from function2(:name)", nativeQuery = true)
    List<Doctor> getDoctorByName(String name);

    @Query(value = "select * from function3()", nativeQuery = true)
    List<DoctorSimpleDTO> getDoctors();
}
