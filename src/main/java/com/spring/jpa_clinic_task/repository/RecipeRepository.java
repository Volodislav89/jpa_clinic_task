package com.spring.jpa_clinic_task.repository;

import com.spring.jpa_clinic_task.model.DoctorRecipeStatistic;
import com.spring.jpa_clinic_task.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "select * from recipes join patients on recipes.patient_id = patients.patient_id where patients.phone_number = :number", nativeQuery = true)
    List<Recipe> recipesByPatientsNumber(@Param("number") String number);

    @Query(value = "select new com.spring.jpa_clinic_task.model.DoctorRecipeStatistic(d.firstName, d.lastName, d.specialization, count(r.patient)) " +
            "from Recipe r " +
            "join Doctor d " +
            "on r.doctor.doctorId = d.doctorId " +
            "group by d.firstName, d.lastName, d.specialization")
    List<DoctorRecipeStatistic> stats();
}
