package com.maouia.tv.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.maouia.tv.entities.Categorie;
import com.maouia.tv.entities.tv;
@RepositoryRestResource(path = "rest")
public interface tvRepository extends JpaRepository<tv,Long> {
	
	List <tv> findByNomtv(String nom);
	List <tv> findByNomtvLike(String nom);
	List <tv> findByNomtvContains(String nom);
	
	@Query("select t from tv t where t.nomtv like %?1 and t.prixtv > ?2") 
	List<tv> findByNomPrix (String nom, Double prix);
	
	@Query("select t from tv t where t.categorie = ?1") 
	List<tv> findByCategorie (Categorie categorie);
	
	List<tv> findByCategorieIdCat(Long id);
	List<tv> findByOrderByNomtvAsc();
	@Query("select t from tv t order by t.nomtv ASC, t.prixtv DESC")
	List<tv> triertvsNomsPrix ();
	
}
