package com.spring.jpa_clinic_task.repository;

import com.spring.jpa_clinic_task.model.Role;
import com.spring.jpa_clinic_task.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}