package com.projet.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.model.Menu;
import com.projet.app.model.Plat;
import com.projet.app.repository.MenuRepository;



@Service
public class MenuService {
	@Autowired
	private MenuRepository mr;
	
	public Menu addMenu(Menu menu) {
		return mr.save(menu);
	}
	
	public List<Menu> getAll(){
		return mr.findAll();
	}
	
	public Menu getMenuById(Long id) {
		Optional<Menu> menu= mr.findById(id);
		if(menu.isPresent()) {
			return menu.get();
		}
		return null;
	}
	
	public Menu updateMenu(Long id, Menu menu) {
		
        Menu existingMenu = getMenuById(id);
        existingMenu.setDate(menu.getDate());
        existingMenu.setPlats(menu.getPlats());
        return mr.save(existingMenu);
    }
	
	public void deleteMenu(Long id) {
        Menu menu = getMenuById(id);
        mr.delete(menu);
    }
	
	public Menu getMenuDuJourActuel() {
        
        LocalDate dateActuelle = LocalDate.now();
        return mr.findByDate(dateActuelle);
    }
	
	public Plat getPlatFromMenu(Menu menu) {
	    
	    if (menu != null && !menu.getPlats().isEmpty()) {
	        
	        for (Plat plat : menu.getPlats()) {
	           
	            if (plat.getQteDisponible() > 0) {
	                return plat; 
	            }
	        }
	        
	    }
	    return null;
	}
	
}
