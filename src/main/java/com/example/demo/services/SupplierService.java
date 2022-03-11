package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	public ResponseEntity<List<Supplier>> getAllSuppliers(){
		try {
			List<Supplier> suppliers=supplierRepository.findAll();
			
			
			if(suppliers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(suppliers,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Supplier> getSupplierById(long id){
		try {
			Optional<Supplier> supplier = supplierRepository.findById(id);
			if(supplier.isPresent()) {
				return new ResponseEntity<>(supplier.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<HttpStatus> deleteSupplier(long id){
		try {
			supplierRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Supplier>createSupplier(Supplier supplier){
		try {
			Supplier _supplier = supplierRepository.save(new Supplier(supplier.getAddress(),supplier.getEmail(),supplier.getFull_name(),supplier.getGender(),supplier.getImage(),supplier.getPassword(),supplier.getPhone(),supplier.getStatus(),supplier.getUser_name()));
			return new ResponseEntity<>(_supplier,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
