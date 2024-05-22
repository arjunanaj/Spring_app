package com.StudentManagement.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class OtpServiceImpl implements OtpService {
	@Autowired
	private JavaMailSender   javaMailSender;

	@Override
	public String generateOtp(String email) throws Exception {
	String otp =toGenerateOtp();
	SimpleMailMessage mailMessage=new SimpleMailMessage();
	mailMessage.setTo(email);
	mailMessage.setSubject("Otp verification");
	mailMessage.setText("Your otp for password cahnge" +otp);
	
	javaMailSender.send(mailMessage);
		return otp;
		
	}

	public String toGenerateOtp() {
		int optLength=6;
		String optnumber="123456789";
		StringBuilder stringBuilder=new StringBuilder(optLength);
		for(int i=0;i<optLength;i++) {
			int index=new Random().nextInt(optnumber.length());
			stringBuilder.append(optnumber.charAt(index));
		}
		return stringBuilder.toString();
	}

}
