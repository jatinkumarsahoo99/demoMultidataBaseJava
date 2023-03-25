package com.eCommmarce.demo.mysql.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eCommmarce.demo.mysql.entity.DemoTable2;

@Repository
public interface DemoRepoMysqlCurd extends CrudRepository<DemoTable2, Integer> {
	
	@Query(value = "select count(*) from demo_tbl2",nativeQuery = true)
	public Integer fetchCusCount();
	
	
	@Procedure(value = "get_count")
	public Integer getCo();
	
	@Procedure("insertdata")
	public void insertdata(String data);
	
	@Procedure(name="demo")
	public Map<String,Object> insertdata1(String data);
	
	@Query(value="CALL insertdata2(?)",nativeQuery = true)
	public List<DemoTable2> insertdata2(String data);

}
