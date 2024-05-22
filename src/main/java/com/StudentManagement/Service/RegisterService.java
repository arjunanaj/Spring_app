package com.StudentManagement.Service;

import org.springframework.web.multipart.MultipartFile;

import com.StudentManagement.Model.RegisterDTO;



public interface RegisterService {
	
	public void addNewUser(RegisterDTO registerDTO) throws Exception;
	
	public void deleteUser(String emailId) throws Exception;
	public void updateUser(String emailId,RegisterDTO registerDTO )throws Exception;
	public void updateImage(String emailId,MultipartFile image ) throws Exception;
	public byte[] getimage(String filename) throws Exception;
}
