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
public class Abstract {
	
	@Id
	@SequenceGenerator(name="abs_gen",sequenceName = "abs_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "abs_gen",strategy = GenerationType.AUTO)
	private Integer id;
	  @Column(columnDefinition = "text")
	private String abstractDef;
	@Lob
	
	private byte[] abstractImage;

}
