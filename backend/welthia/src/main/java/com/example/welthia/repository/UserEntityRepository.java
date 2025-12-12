package com.example.welthia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.welthia.models.user.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{
}
