package com.projet.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.model.Menu;
import com.projet.app.model.Plat;
import com.projet.app.repository.MenuRepository;
import com.projet.app.repository.PlatRepository;

@Service
public class PlatService {

	@Autowired
	private PlatRepository pr;
	@Autowired
	private MenuRepository mr;
	
	public Plat createPlat(Long menuId,Plat plat) {
		Optional<Menu> menu= mr.findById(menuId);
		if(menu.isPresent()) {
			Menu menu1=menu.get();
			plat.setMenu(menu1);
			return pr.save(plat);
		}
		return null;
	}
	
	public List<Plat> getAllPlats(){
		return pr.findAll();
	}
	
	public Plat getPlatById(Long id) {
		Optional<Plat> plat= pr.findById(id);
		if(plat.isPresent()) {
			return plat.get();
		}
		return null;
	}
	
	public Plat updatePlat(Long id, Plat plat) {
		
        Plat existingPlat = getPlatById(id);
        existingPlat.setDescription(plat.getDescription());
        existingPlat.setDessert(plat.getDessert());
        existingPlat.setQteDisponible(plat.getQteDisponible());
        return pr.save(existingPlat);
        
    }
	
	public void deletePlat(Long id) {
        Plat plat=getPlatById(id);
        pr.delete(plat);
    }

	public List<Plat> getAllPlatsByMenu(Menu menu) {
		return pr.findByMenu(menu);
	}
	
	
}
