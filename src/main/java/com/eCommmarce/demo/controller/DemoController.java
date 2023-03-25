package com.eCommmarce.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eCommmarce.demo.mysql.entity.DemoTable2;
import com.eCommmarce.demo.mysql.repository.DemoRepoMysql;
import com.eCommmarce.demo.mysql.repository.DemoRepoMysqlCurd;
import com.eCommmarce.demo.postgresql.repository.DemoRepoPostgre;

@RestController
public class DemoController {
	
	@Autowired
	private DemoRepoPostgre repo1;
	
	@Autowired
	private DemoRepoMysql repo2;
	
	@Autowired
	private DemoRepoMysqlCurd democurd;
	
	
	@GetMapping("/student")
	public String  getAll() 
	{
		
		return "It's Working"+democurd.getCo().toString();
	}
	

	@PostMapping("/insert")
	public String  insertData(@RequestBody DemoTable2 data) 
	{
		
		String values = "SET @p_dename='" + data.getDemoName() + "',@p_name='" + data.getName()
		+ "',@p_time='" + data.getTime() + "';";
	
		democurd.insertdata(values);
		return "It's Working";
	}
	
	@PostMapping("/insertData")
	public Map<String,Object>  insertData1(@RequestBody DemoTable2 data) 
	{
		
		String values = "SET @p_dename='" + data.getDemoName() + "',@p_name='" + data.getName()
		+ "',@p_time='" + data.getTime() + "';";

		return democurd.insertdata1(values);
	}
	
	@PostMapping("/insertDataN")
	public List<DemoTable2>  insertData2(@RequestBody DemoTable2 data) 
	{
		
		String values = "SET @p_dename='" + data.getDemoName() + "',@p_name='" + data.getName()
		+ "',@p_time='" + data.getTime() + "';";

		return democurd.insertdata2(values);
	}
	
	

}
