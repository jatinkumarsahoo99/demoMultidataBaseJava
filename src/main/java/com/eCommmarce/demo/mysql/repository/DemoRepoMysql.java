package com.eCommmarce.demo.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommmarce.demo.mysql.entity.DemoTable2;
import com.eCommmarce.demo.postgresql.entity.DemoTable;

@Repository
public interface DemoRepoMysql extends JpaRepository<DemoTable2, Integer> {
	
	DemoTable findByName(String name);

}
