package com.projet.app.model;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
	
	
	@OneToMany(mappedBy = "menu")
	@JsonIgnore
	private List<Plat> plats=new ArrayList<>();
}
