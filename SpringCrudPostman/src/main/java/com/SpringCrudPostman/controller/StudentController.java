package com.SpringCrudPostman.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCrudPostman.Exception.StudentNotFountException;
import com.SpringCrudPostman.model.Student;
import com.SpringCrudPostman.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/getstudent/{studentId}")
	public Optional<Student> getStudentById(@PathVariable(value="studentId") Long studentId)
	{
		Optional<Student> student=studentRepository.findById(studentId);
		
		if(!student.isPresent())
		{
			throw new StudentNotFountException("StudentId : " + studentId+" Not Found.");
		}
		
		return student;
	}
	
	@GetMapping("/allstudent")
	public List<Student> getAllStudent()
	{
		return (List<Student>) studentRepository.findAll();
	}
	
	@PostMapping("/addstudent")
	public void addStudent(@RequestBody Student student)	
	{
			studentRepository.save(student);
	}
	
	@PutMapping(value="/updatestudent")
	public Student updateStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	@DeleteMapping(value="/deletestudent/{studentId}")
	public void deleteStudent(@PathVariable(value="studentId") Long studentId)
	{	
		studentRepository.deleteById(studentId);
	}
}
