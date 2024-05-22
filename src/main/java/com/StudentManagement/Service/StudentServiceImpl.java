package com.StudentManagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.Entity.Student;
import com.StudentManagement.Model.StudentDTO;
import com.StudentManagement.Repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void addNewStudent(StudentDTO studentDTO) throws Exception {
	
		
		Student student=new Student();
	    student.setFirstName(studentDTO.getFirstName());
	    student.setLastName(studentDTO.getLastName());
	    student.setCourse(studentDTO.getCourse() );
	    student.setAdmissionDate(studentDTO.getAdmissionDate());
	    student.setAdmissionFees(studentDTO.getAdmissionFees());
	    student.setPhoneNumber(studentDTO.getPhoneNumber());
	    student.setAddress(studentDTO.getAddress());
		studentRepository.save(student);
			
		
	}

	@Override
	public StudentDTO getStudent(String name) throws Exception {
		Optional<Student> optional=studentRepository.findByfirstName(name);
		Student student=optional.orElseThrow(()-> new Exception("Service.Not_Found"));
		StudentDTO studentDTO=new StudentDTO();
		    studentDTO.setFirstName(student.getFirstName());
		    studentDTO.setLastName(student.getLastName());
		    studentDTO.setCourse(student.getCourse());
		    studentDTO.setAdmissionDate(student.getAdmissionDate());
		    studentDTO.setAdmissionFees(student.getAdmissionFees());
		    studentDTO.setPhoneNumber(student.getPhoneNumber());
		    studentDTO.setAddress(student.getAddress());
		return studentDTO;
	}

	
	public void updateStudent(Integer id, StudentDTO studentDTO) throws Exception {
		Optional<Student> optional=studentRepository.findById(id);
		Student student=optional.orElseThrow(()-> new Exception("Service.Not_Found"));
		  student.setFirstName(studentDTO.getFirstName());
		    student.setLastName(studentDTO.getLastName());
		    student.setCourse(studentDTO.getCourse() );
		    student.setAdmissionDate(studentDTO.getAdmissionDate());
		    student.setAdmissionFees(studentDTO.getAdmissionFees());
		    student.setPhoneNumber(studentDTO.getPhoneNumber());
		    student.setAddress(studentDTO.getAddress());
		    studentRepository.save(student);
		
	}


	public void deleteStudent(Integer id) throws Exception {
		Optional<Student> optional=studentRepository.findById(id);
		if(optional.isEmpty()) {
			throw new Exception("Service.Not_Found");
		}
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<StudentDTO> getAllStudent() throws Exception {
	List<StudentDTO> studentList=new ArrayList<>();
	Iterable<Student> stdFromRepo=studentRepository.findAll();
	for(Student students:stdFromRepo) {
		StudentDTO studentDTO=new StudentDTO();
		  studentDTO.setId(students.getId());
		   studentDTO.setFirstName(students.getFirstName());
		    studentDTO.setLastName(students.getLastName());
		    studentDTO.setCourse(students.getCourse());
		    studentDTO.setAdmissionDate(students.getAdmissionDate());
		    studentDTO.setAdmissionFees(students.getAdmissionFees());
		    studentDTO.setPhoneNumber(students.getPhoneNumber());
		    studentDTO.setAddress(students.getAddress());
		studentList.add(studentDTO);
	}
		return studentList;
	}

	@Override
	public StudentDTO getStudentById(Integer id) throws Exception {
		
		Optional<Student> optional=studentRepository.findById(id);
		Student student=optional.orElseThrow(()-> new Exception("Service.Not_Found"));
		StudentDTO studentDTO=new StudentDTO();
		    studentDTO.setId(student.getId());
		    studentDTO.setFirstName(student.getFirstName());
		    studentDTO.setLastName(student.getLastName());
		    studentDTO.setCourse(student.getCourse());
		    studentDTO.setAdmissionDate(student.getAdmissionDate());
		    studentDTO.setAdmissionFees(student.getAdmissionFees());
		    studentDTO.setPhoneNumber(student.getPhoneNumber());
		    studentDTO.setAddress(student.getAddress());
		return studentDTO;
	}
	
	

}
