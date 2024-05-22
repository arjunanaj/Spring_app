package com.StudentManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagement.Entity.Abstract;



@Repository
public interface AbstractRepository  extends JpaRepository<Abstract, Integer>{
 
	Optional<Abstract> findFirstByOrderByIdDesc();
}
