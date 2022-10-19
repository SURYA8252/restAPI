package com.testapi.service;

import java.util.List;

import com.testapi.payload.StudentDto;

public interface StudentService {
	//Get All Student
    List<StudentDto> getAllStudent();
    //Get Student by id
    StudentDto getStudentById(int id);
    //Save Student
    StudentDto saveStudent(StudentDto studentDto);
    //Update Student
    StudentDto updateStudent(int id,StudentDto studentDto);
    //Delete Student
    void deleteStudent(int id);
}
