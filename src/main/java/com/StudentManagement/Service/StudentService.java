package com.StudentManagement.Service;

import java.util.List;

import com.StudentManagement.Model.StudentDTO;


public interface StudentService {
	
	public void addNewStudent(StudentDTO studentDTO) throws Exception;
	public StudentDTO getStudent(String name) throws Exception;
	public StudentDTO getStudentById(Integer id) throws Exception;
	public void updateStudent(Integer id, StudentDTO  studentDTO) throws Exception;
	public void deleteStudent(Integer id) throws Exception;
	public List<StudentDTO> getAllStudent() throws Exception;
	
	

}
