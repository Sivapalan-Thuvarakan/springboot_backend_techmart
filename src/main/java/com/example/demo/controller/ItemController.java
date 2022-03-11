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
import com.example.demo.model.User;
import com.example.demo.services.itemService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class ItemController {

	@Autowired
	itemService itemservice;
	
	//Get All Items
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems(){
		return itemservice.getAllItems();
	}
	
	//Get  Item By Id
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable("id") long id){
		return itemservice.getItemById(id);
	}
	
	//delete item by id
	@DeleteMapping("/delete/items/{id}")
	public ResponseEntity<HttpStatus> deleteItemById(@PathVariable("id") long id){
		return  itemservice.deleteItem(id);
	}
		
	@PostMapping("/item")
	public ResponseEntity<Item> createItem(@RequestBody Item item)
	{
		return itemservice.createItem(item);
	}

	
}
