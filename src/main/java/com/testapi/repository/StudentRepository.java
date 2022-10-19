package com.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testapi.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Integer>{

}
