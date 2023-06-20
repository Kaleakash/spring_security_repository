package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Student;
import com.bean.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
	// to write custom query in DAO repository 
	// JPQL 
	@Query("select t from Trainer t where t.tech = :tech")			//JPQL 
	//@Query(value= "select * from Trainer t where t.tech = :tech",nativeQuery = true)
	public List<Trainer> searchTrainerByTech(@Param("tech") String tech);
	
}
