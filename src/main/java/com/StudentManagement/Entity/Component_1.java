package com.StudentManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class Component_1 {

	@Id
	@SequenceGenerator(name = "cmp1_gen", sequenceName = "cmp1_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "cmp1_gen", strategy = GenerationType.AUTO)
	private Integer id;
	@Column(columnDefinition = "text")
	private String componentDef;
	@Lob

	private byte[] componentImage1;
	@Lob

	private byte[] componentImage2;
	@Lob
	private byte[] componentImage3;

}
