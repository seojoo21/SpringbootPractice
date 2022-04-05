package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Column(length=1024)
	private String address;
	private String primaryContact;

}
