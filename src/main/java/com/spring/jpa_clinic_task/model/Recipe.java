package com.spring.jpa_clinic_task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnoreProperties(value = {"recipes"})
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnoreProperties(value = {"recipes"})
    private Doctor doctor;

    @Column(name = "assigment_date")
    private LocalDate assigmentDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private RecipePriority priority;
}
