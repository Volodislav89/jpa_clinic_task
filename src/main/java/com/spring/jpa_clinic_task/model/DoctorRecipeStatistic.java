package com.spring.jpa_clinic_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRecipeStatistic {
    private String firstName;
    private String lastName;
    private String specialization;
    private Long count;
}
