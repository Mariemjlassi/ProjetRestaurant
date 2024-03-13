package com.projet.app.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity

public class Etudiant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motdepasse;
    private String numeroEtudiant;
    private double soldeCarte;
    
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Paiement> paiements = new ArrayList<>();
    
   
    

}
