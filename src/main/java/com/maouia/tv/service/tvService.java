package com.maouia.tv.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maouia.tv.entities.Categorie;
import com.maouia.tv.entities.tv;

public interface tvService {
	tv savetv(tv p);
	tv updatetv(tv p);
	void deletetv(tv p);
	void deletetvById(Long id);
	tv gettv(Long id);
	List<tv> getAlltvs();
	Page<tv> getAlltvsParPage(int page, int size);
	
	List<tv> findByNomtv(String nom); 
	List<tv> findByNomtvContains(String nom); 
	List<tv> findByNomPrix (String nom, Double prix); 
	List<tv> findByCategorie (Categorie categorie); 
	List<tv> findByCategorieIdCat(Long id); 
	List<tv> findByOrderByNomtvAsc(); 
	List<tv> triertvsNomsPrix(); 


}
