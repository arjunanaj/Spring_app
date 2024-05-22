package com.StudentManagement.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	@SequenceGenerator(name="std_gen",sequenceName = "std_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "std_gen",strategy = GenerationType.AUTO)
	private Integer Id;
	private String firstName;
	private String lastName;
	private String course;
	private Date admissionDate;
	private Integer admissionFees;
	private String phoneNumber;
	private String address;
	

}
