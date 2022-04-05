package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<Customer> findByName(String name);
	List<Customer> findByNameLike(String name);
	List<Customer> findByNameLikeOrderByAddressDesc(String name);
	List<Customer> findByNameAndAddress(String name, String address);
	List<Customer> findByNameOrAddress(String name, String address);
	
//	@Query("", nativeQuery=true) // true=표준 SQL , false=JPQL
	
	@Query("from Customer where name =?1 and address = ?2") //JPQL
 	List<Customer> findVipList(String value1, String value2);
	
	@Query(value="select * from Customer where name =?1 and address = ?2", nativeQuery=true ) //SQL
 	List<Customer> findVipList2(String value1, String value2);
	
}
