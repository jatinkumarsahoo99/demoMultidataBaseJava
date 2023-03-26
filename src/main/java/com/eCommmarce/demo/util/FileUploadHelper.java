package com.eCommmarce.demo.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR = "E:\\javaSpring\\eCommmarce-1\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile multipartfile) {
		boolean f = false;

		try {

			/*
			 * InputStream is = multipartfile.getInputStream(); byte data[] = new
			 * byte[is.available()];
			 * 
			 * is.read(data);
			 * 
			 * FileOutputStream fos = new
			 * FileOutputStream(UPLOAD_DIR+"\\"+multipartfile.getOriginalFilename());
			 * 
			 * fos.write(data); fos.flush(); fos.close();
			 */

			// or

			
			  Files.copy(multipartfile.getInputStream(),Paths.get(UPLOAD_DIR+"\\"+
			  multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			 

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
