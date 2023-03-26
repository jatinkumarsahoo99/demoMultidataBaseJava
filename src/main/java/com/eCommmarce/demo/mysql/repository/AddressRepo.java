package com.eCommmarce.demo.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.eCommmarce.demo.mysql.entity.Address;

public interface AddressRepo extends CrudRepository<Address, Integer> {

}
