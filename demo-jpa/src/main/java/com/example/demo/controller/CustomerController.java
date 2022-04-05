package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Customer;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CustomerController {
	
	private CustomerRepository repository;
	
	@PostMapping("/customer")
	public Customer postCustomer(Customer customer) {
		return repository.save(customer);
	}
	
	@PutMapping("/customer")
	public Customer putCustomer(Customer customer) {
		return repository.save(customer);
	}
	
	@DeleteMapping("/customer")
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/customer")
	public Customer getCustomer(int id) {
//		return repository.findById(id).orElse(null);
		return repository.findById(id).orElseThrow();
	}
	
	@GetMapping("/customer/List")
	public List<Customer> getCustomerList(){
		return (List<Customer>) repository.findAll();
	}
	
	@GetMapping("/customer/name")
	public List<Customer> getCustomer(String name){
		return repository.findByName(name);
	}
	
	@GetMapping("/customer/search")
	public List<Customer> searchCustomer(String name){
		return repository.findByNameLike("%" + name + "%");
	}
}
