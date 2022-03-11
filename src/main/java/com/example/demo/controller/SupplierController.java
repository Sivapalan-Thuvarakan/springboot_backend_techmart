package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.model.Supplier;
import com.example.demo.services.SupplierService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	//Get All Suppliers
		@GetMapping("/suppliers")
		public ResponseEntity<List<Supplier>> getAllSuppliers(){
			return supplierService.getAllSuppliers();
		}
		
		//Get  Supplier By Id
		
		@GetMapping("/suppliers/{id}")
		public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") long id){
			return supplierService.getSupplierById(id);
		}
		
		//delete Supplier by id
		@DeleteMapping("/delete/supplier/{id}")
		public ResponseEntity<HttpStatus> deleteSupplierById(@PathVariable("id") long id){
			return  supplierService.deleteSupplier(id);
		}
			
		
		//create supplier 
		@PostMapping("/supplier")
		public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier)
		{
			return supplierService.createSupplier(supplier);
		}


}
