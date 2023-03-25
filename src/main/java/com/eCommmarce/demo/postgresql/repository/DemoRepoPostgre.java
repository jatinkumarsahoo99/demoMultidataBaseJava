package com.eCommmarce.demo.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommmarce.demo.postgresql.entity.DemoTable;

@Repository
public interface DemoRepoPostgre extends JpaRepository<DemoTable, Integer>{
	
	DemoTable findByName(String name);
}
