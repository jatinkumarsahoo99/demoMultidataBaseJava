package com.eCommmarce.demo.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.eCommmarce.demo.mysql.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
