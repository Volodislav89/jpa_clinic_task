package com.spring.jpa_clinic_task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RecipePriority {
    NORMAL("normal"),
    CITO("cito"),
    STATIM("statim");

    private String value;
}
