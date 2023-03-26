package com.eCommmarce.demo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eCommmarce.demo.mysql.entity.ImageData;
import com.eCommmarce.demo.mysql.repository.StorageRepository;
import com.eCommmarce.demo.util.ImageUtils;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {
    	
    	System.out.println("file"+file.toString());

    	ImageData data = new ImageData();
    	data.setName(file.getOriginalFilename());
    	data.setImageData(ImageUtils.compressImage(file.getBytes()));
    	data.setType(file.getContentType());
    	
        ImageData imageData = repository.save(data);
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return "Something went wrong";
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
