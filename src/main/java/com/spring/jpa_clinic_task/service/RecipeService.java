package com.spring.jpa_clinic_task.service;

import com.spring.jpa_clinic_task.model.Doctor;
import com.spring.jpa_clinic_task.model.DoctorRecipeStatistic;
import com.spring.jpa_clinic_task.model.Patient;
import com.spring.jpa_clinic_task.model.Recipe;
import com.spring.jpa_clinic_task.repository.DoctorRepository;
import com.spring.jpa_clinic_task.repository.PatientRepository;
import com.spring.jpa_clinic_task.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeService {
    private RecipeRepository recipeRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe findRecipeById(Long recipeId) throws Exception {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new Exception(String.format("No recipe with id: %d was found.", recipeId)));
    }

    public Recipe saveRecipe(Recipe recipe, Long patientId, Long doctorId) {
        LocalDate assigmentDate = LocalDate.now();
        try {
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new Exception(String.format("No patient with id: %d was found.", patientId)));
            Doctor doctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new Exception(String.format("No doctor with id: %d was found.", doctorId)));
            recipe.setPatient(patient);
            recipe.setDoctor(doctor);
            recipe.setAssigmentDate(assigmentDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeRepository.save(recipe);
    }

    @Transactional
    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    public List<Recipe> getRecipesByDescription(String pattern) {
        List<Recipe> recipeList = recipeRepository.findAll()
                .stream()
                .filter(r -> r.getDescription().contains(pattern))
                .collect(Collectors.toList());
        return recipeList;
    }

    public List<Recipe> getRecipesByPatientsPhoneNumber(String phoneNumber) {
        return recipeRepository.recipesByPatientsNumber(phoneNumber);
    }

    public List<DoctorRecipeStatistic> statisticInformation() {
        return recipeRepository.stats();
    }
}
