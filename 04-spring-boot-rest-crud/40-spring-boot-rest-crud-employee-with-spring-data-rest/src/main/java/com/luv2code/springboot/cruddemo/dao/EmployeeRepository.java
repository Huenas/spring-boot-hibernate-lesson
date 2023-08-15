package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members") // will expose /members instead of /employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //entity = employee, PK = integer


        // no need to write any code
}
