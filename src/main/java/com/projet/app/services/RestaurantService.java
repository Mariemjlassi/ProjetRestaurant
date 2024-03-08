package com.projet.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public int getNombrePlacesDisponibles() {
		int nbpDisponible= 100;
		return nbpDisponible;
	}

}
