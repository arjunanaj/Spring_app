package com.StudentManagement.Model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
	private Integer Id;
	private String firstName;
	private String lastName;
	private String course;
	private Date admissionDate;
	private Integer admissionFees;
	private String phoneNumber;
	private String address;
	

}
