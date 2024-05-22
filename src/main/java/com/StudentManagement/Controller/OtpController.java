package com.StudentManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.Service.OtpService;

@RestController
@RequestMapping("/Login")
public class OtpController {

	@Autowired
	private OtpService otpService;

	@PostMapping("/forgotPassword")
	public ResponseEntity<String> otpVerification(@RequestParam("email") String email) throws Exception {

		ResponseEntity<String> response = null;
		try {
			String otp = otpService.generateOtp(email);
			response = new ResponseEntity<String>(otp, HttpStatus.CREATED);
			System.out.println(otp);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
