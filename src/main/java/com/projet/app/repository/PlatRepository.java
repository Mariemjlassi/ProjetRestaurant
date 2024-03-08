package com.projet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.model.Plat;


@Repository
public interface PlatRepository extends JpaRepository<Plat, Long>{

}
