package com.StudentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.Model.StudentDTO;
import com.StudentManagement.Service.StudentService;



@RestController()
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/addstudent")
	  public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
		 studentService.addNewStudent(studentDTO);
		 
		  response=new   ResponseEntity<String>(HttpStatus.CREATED);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		  
		  
		  
	  }
	  
		@GetMapping("/getstudent")
	  public ResponseEntity<StudentDTO> getStudent(@RequestParam("name") String name)throws Exception{
			ResponseEntity<StudentDTO> response=null;
		  
		  try {
			  StudentDTO std=studentService.getStudent(name);
			   response= new  ResponseEntity<StudentDTO>(std,HttpStatus.OK);
		  }catch (Exception e) {
			throw e;
		}

		return response;
		  
	  }
		@GetMapping("/getstudentById")
		  public ResponseEntity<StudentDTO> getStudent(@RequestParam("id") Integer id)throws Exception{
				ResponseEntity<StudentDTO> response=null;
			  
			  try {
				  StudentDTO std=studentService.getStudentById(id);
				   response= new  ResponseEntity<StudentDTO>(std,HttpStatus.OK);
			  }catch (Exception e) {
				throw e;
			}

			return response;
			  
		  }
		
	  @DeleteMapping("/deleteStudent")
	  public ResponseEntity<String> deleteStudent(@RequestParam("id") Integer id) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		     studentService.deleteStudent(id);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  
	  @PutMapping("/updateStudent")
	  public ResponseEntity<String> updateStudent(@RequestParam("id") Integer id,@RequestBody StudentDTO studentDTO ) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
		 
            studentService.updateStudent(id, studentDTO);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  @GetMapping("/getAllStudent")
	  public ResponseEntity<List<StudentDTO>>getStudentList()throws Exception{
			ResponseEntity<List<StudentDTO>>response=null;
		  
		  try {
			  List<StudentDTO> std=studentService.getAllStudent();
			   response= new ResponseEntity<List<StudentDTO>> (std,HttpStatus.OK);
		  }catch (Exception e) {
		 throw e;
		}

		return response;
		  
	}
	   

}
