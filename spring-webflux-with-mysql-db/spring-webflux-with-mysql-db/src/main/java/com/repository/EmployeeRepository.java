package com.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Employee;



@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long>{
	
	@Query("update employee set salary = :sal where id = :eid")
	public void updateEmployeeRecord(@Param("sal") float salary, @Param("eid") Long id);
}
