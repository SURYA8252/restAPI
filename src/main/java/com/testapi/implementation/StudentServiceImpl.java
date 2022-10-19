package com.testapi.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapi.model.StudentModel;
import com.testapi.payload.StudentDto;
import com.testapi.repository.StudentRepository;
import com.testapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<StudentDto> getAllStudent() {
		List<StudentModel> list = this.studentRepository.findAll();
		List<StudentDto> list2 = list.stream().map((student)->this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return list2;
	}

	@Override
	public StudentDto getStudentById(int id) {
		StudentModel getByIdStudent = this.studentRepository.findById(id).get();
		StudentDto studentDto = this.modelMapper.map(getByIdStudent, StudentDto.class);
		return studentDto;
	}

	@Override
	public StudentDto saveStudent(StudentDto studentDto) {
		StudentModel student = this.modelMapper.map(studentDto, StudentModel.class);
		StudentModel savedStudent = this.studentRepository.save(student);
		StudentDto studentDto2 = this.modelMapper.map(savedStudent, StudentDto.class);
		return studentDto2;
	}

	@Override
	public StudentDto updateStudent(int id, StudentDto studentDto) {
		StudentModel studentById = this.studentRepository.findById(id).get();
		studentById.setStudentName(studentDto.getStudentName());
		studentById.setStudentAddress(studentDto.getStudentAddress());
		studentById.setStudentPhone(studentDto.getStudentPhone());
		StudentDto studentDto2 = this.modelMapper.map(studentById, StudentDto.class);
		return studentDto2;
	}

	@Override
	public void deleteStudent(int id) {
		StudentModel student = this.studentRepository.findById(id).get();
		this.studentRepository.delete(student);
	}

}
