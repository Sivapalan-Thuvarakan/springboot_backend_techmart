package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.model.Item;
import com.example.demo.model.User;
import com.example.demo.repository.ItemRepository;

@Service
public class itemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public ResponseEntity<List<Item>> getAllItems(){
		try {
			List<Item> items=itemRepository.findAll();
			
			
			if(items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(items,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Item> getItemById(long id){
		try {
			Optional<Item> item = itemRepository.findById(id);
			if(item.isPresent()) {
				return new ResponseEntity<>(item.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<HttpStatus> deleteItem(long id){
		try {
			itemRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Item>createItem(Item item){
		try {
			Item _item = itemRepository.save(new Item(item.getDescription(),item.getImage(),item.getStatus(),item.getTitle(),item.getPrice(),item.getQuantity()));
			return new ResponseEntity<>(_item,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
