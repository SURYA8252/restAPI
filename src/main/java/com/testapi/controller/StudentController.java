package com.testapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testapi.payload.StudentDto;
import com.testapi.service.StudentService;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {
	@Autowired
    private StudentService studentService;
	//Get All Student
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudent() {
		List<StudentDto> allStudent = this.studentService.getAllStudent();
		return new ResponseEntity<List<StudentDto>>(allStudent,HttpStatus.OK);
	}
	//Get Student by id
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable int id) {
		StudentDto studentById = this.studentService.getStudentById(id);
		return new ResponseEntity<StudentDto>(studentById,HttpStatus.OK);
	}
	//Create Student
	@PostMapping("/")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
		StudentDto saveStudent = this.studentService.saveStudent(studentDto);
		return new ResponseEntity<StudentDto>(saveStudent,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable int id,@RequestBody StudentDto studentDto) {
		StudentDto updateStudent = this.studentService.updateStudent(id, studentDto);
		return new ResponseEntity<StudentDto>(updateStudent,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public Boolean deleteStudent(@PathVariable int id) {
		this.studentService.deleteStudent(id);
		return true;
	}
}
