package com.eCommmarce.demo.mysql.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.eCommmarce.demo.mysql.entity.ImageData;

public interface StorageRepository extends CrudRepository<ImageData, Long> {
	Optional<ImageData> findByName(String fileName);
}
