package com.maouia.tv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.maouia.tv.entities.Categorie;
import com.maouia.tv.entities.tv;
import com.maouia.tv.repos.tvRepository;
@Service
public class tvServiceImpl implements tvService{
	
	@Autowired
	tvRepository tvrepository;
	@Override
	public tv savetv(tv p) {
		return tvrepository.save(p);
		
	}

	@Override
	public tv updatetv(tv p) {
		return tvrepository.save(p);
	}

	@Override
	public void deletetv(tv p) {
		tvrepository.delete(p);
		
	}

	@Override
	public void deletetvById(Long id) {
		tvrepository.deleteById(id);
		
	}

	@Override
	public tv gettv(Long id) {

		return tvrepository.findById(id).get();
	}

	@Override
	public List<tv> getAlltvs() {
		
		return tvrepository.findAll();
	}

	@Override
	public Page<tv> getAlltvsParPage(int page, int size) {
		return tvrepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<tv> findByNomtv(String nom) {
		
		return tvrepository.findByNomtv(nom);
	}

	@Override
	public List<tv> findByNomtvContains(String nom) {
		
		return tvrepository.findByNomtvContains(nom);
	}

	@Override
	public List<tv> findByNomPrix(String nom, Double prix) {
		
		return tvrepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<tv> findByCategorie(Categorie categorie) {
		
		return tvrepository.findByCategorie(categorie);
	}

	@Override
	public List<tv> findByCategorieIdCat(Long id) {
		
		return tvrepository.findByCategorieIdCat(id);
	}

	@Override
	public List<tv> findByOrderByNomtvAsc() {
		
		return tvrepository.findByOrderByNomtvAsc();
	}

	@Override
	public List<tv> triertvsNomsPrix() {
	
		return tvrepository.triertvsNomsPrix();
	}

	

}
