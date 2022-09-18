package com.exam.examproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examproject.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
