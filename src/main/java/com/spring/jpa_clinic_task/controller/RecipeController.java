package com.spring.jpa_clinic_task.controller;

import com.spring.jpa_clinic_task.model.DoctorRecipeStatistic;
import com.spring.jpa_clinic_task.model.Recipe;
import com.spring.jpa_clinic_task.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> findAllRecipes() {
        return recipeService.findAllRecipes();
    }

    @GetMapping("/{recipeId}")
    public Recipe findRecipeById(@PathVariable Long recipeId) throws Exception {
        return recipeService.findRecipeById(recipeId);
    }

    @GetMapping("description/{pattern}")
    public List<Recipe> getRecipesByDescription(@PathVariable String pattern) {
        return recipeService.getRecipesByDescription(pattern);
    }

    @GetMapping("/phone/{number}")
    public List<Recipe> getRecipesByPatientsPhoneNumber(@PathVariable String number) {
        return recipeService.getRecipesByPatientsPhoneNumber(number);
    }

    @GetMapping("/statistic")
    public List<DoctorRecipeStatistic> statisticInformation() {
        return recipeService.statisticInformation();
    }

    @PostMapping("/{patientId}/{doctorId}")
    public Recipe saveRecipe(@RequestBody Recipe recipe, @PathVariable Long patientId, @PathVariable Long doctorId) {
        return recipeService.saveRecipe(recipe, patientId, doctorId);
    }

    @DeleteMapping("/{recipeId}")
    public void deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteRecipe(recipeId);
    }
}
