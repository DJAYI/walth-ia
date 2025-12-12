package com.example.welthia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.welthia.models.user.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long>{
}
