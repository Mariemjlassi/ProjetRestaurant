package com.projet.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.model.Menu;

import com.projet.app.services.MenuService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MenuController {
	
	@Autowired
	private MenuService ms;
	
	@PostMapping
	public Menu addmenu(@RequestBody Menu menu) {
		return ms.addMenu(menu);
			
	}
	
	@GetMapping
	public List<Menu> getMenu(){
		return ms.getAll();
	}
	
	@GetMapping("/{id}")
	public Menu getMenuById(@PathVariable ("id") Long id) {
		return ms.getMenuById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Menu> update(@PathVariable("id") Long id,@RequestBody Menu menu){
		Menu m=ms.updateMenu(id, menu);
		if(m == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(m);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMenu(@PathVariable ("id") Long id) {
		this.ms.deleteMenu(id);
	}
	
	@GetMapping("/menuj")
	public Menu menuDuJour() {
		return ms.getMenuDuJourActuel();
	}
	

}
