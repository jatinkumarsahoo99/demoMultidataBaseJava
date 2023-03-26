package com.eCommmarce.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eCommmarce.demo.mysql.entity.DemoTable2;
import com.eCommmarce.demo.mysql.entity.Employee;
import com.eCommmarce.demo.mysql.repository.DemoRepoMysql;
import com.eCommmarce.demo.mysql.repository.DemoRepoMysqlCurd;
import com.eCommmarce.demo.mysql.repository.EmployeeRepo;
import com.eCommmarce.demo.postgresql.repository.DemoRepoPostgre;
import com.eCommmarce.demo.service.StorageService;
import com.eCommmarce.demo.util.FileUploadHelper;

@RestController
public class DemoController {
	
	@Autowired
	private DemoRepoPostgre repo1;
	
	@Autowired
	private DemoRepoMysql repo2;
	
	@Autowired
	private DemoRepoMysqlCurd democurd;
	
	@Autowired
	private EmployeeRepo emp;
	
	@Autowired
	private StorageService service;
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	
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
	
	@PostMapping("/saveEmp")
	public Employee  saveEmp(@RequestBody Employee data) 
	{
		return emp.save(data);
	}
	

	@PostMapping("/image")
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/image/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] imageData=service.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
	@PostMapping("/upload-file")
	public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
		
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
			}
			/*
			 * if(!file.getContentType().equals("image/jpeg")) { return
			 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error"); }
			 */
			boolean fStatus = fileUploadHelper.uploadFile(file);
			if(fStatus) {
				return ResponseEntity.ok("File is successfully uploaded");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		
		
		
	}
	

}
