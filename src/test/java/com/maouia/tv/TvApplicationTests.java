package com.maouia.tv;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.maouia.tv.entities.Categorie;
import com.maouia.tv.entities.tv;
import com.maouia.tv.repos.tvRepository;
import com.maouia.tv.service.tvService;

@SpringBootTest
class TvApplicationTests {

	@Autowired
	private tvRepository tvRepository;
	@Autowired
	private tvService tvService;
	@Test
	public void testCreatetvs() {
	tv prod = new tv("sony",1000.600,new Date());
	tvRepository.save(prod);
	}
	
	 @Test
	 public void testFindtv()
	 {
	 tv p = tvRepository.findById(1L).get();
	 System.out.println(p);
	 }
	 @Test
	 public void testUpdatetv()
	 {
	 tv p = tvRepository.findById(1L).get();
	 p.setPrixtv(1000.0);
	 tvRepository.save(p);
	 }
	 @Test
	 public void testDeletetv(){
		 tvRepository.deleteById(1L);
	 }

	 @Test
	 public void testListerToustv()
	 {
	 List<tv> prods = tvRepository.findAll();
	 for (tv p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindByNomtvContains()
	 {
	 Page<tv> prods = tvService.getAlltvsParPage(0,2);
	 System.out.println(prods.getSize());
	 System.out.println(prods.getTotalElements());
	 System.out.println(prods.getTotalPages());
	 prods.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	 /*ou bien
	 for (Produit p : prods)
	 {
	 System.out.println(p);
	 } */
	 }
	 
	 
	 @Test
	 public void testFindtvByNom()
	 {
	 List<tv> prods = tvRepository.findByNomtv("samsung");
	 for(tv p : prods) {
		 System.out.println(p); }
	 }
	 
	 
	 @Test
	 public void testFindtvByNomLike ()
	 {
	 List<tv> prods = tvRepository.findByNomtvLike("samsung");
	 for(tv p : prods) {
		 System.out.println(p); }
	 }
	 
	 @Test
	 public void testFindtvByNomContains ()
	 {
	 List<tv> prods = tvRepository.findByNomtvContains("s");
	 for(tv p : prods) {
		 System.out.println(p); }
	 }
	 
	 
	 @Test 
	 public void testfindByNomPrix() 
	 { 
	 List<tv> prods = tvRepository.findByNomPrix("samsung", 2100.5); for (tv p : prods) 
	 { 
	 System.out.println(p); 
	 } 
	 }
	 
	 @Test 
	 public void testfindByCategorie() 
	 { 
	 Categorie cat = new Categorie(); 
	 cat.setIdCat(1L);
	 List<tv> prods = tvRepository.findByCategorie(cat); for (tv p : prods) 
	 { 
	 System.out.println(p); 
	 } 
	 }
	 
	 @Test 
	 public void findByCategorieIdCat() 
	 { 
	 List<tv> prods = tvRepository.findByCategorieIdCat(1L); for (tv p : prods) 
	 { 
	 System.out.println(p); 
	 }
	 }
	 
	 @Test 
	 public void testfindByOrderByNomProduitAsc() 
	 { 
	 List<tv> prods =  
	 tvRepository.findByOrderByNomtvAsc(); 
	 for (tv p : prods) 
	 { 
	 System.out.println(p); 
	 } 
	 }
	 
	 @Test 
	 public void testTrierProduitsNomsPrix() 
	 { 
	 List<tv> prods = tvRepository.triertvsNomsPrix(); 
	 for (tv p : prods) 
	 { 
	 System.out.println(p); 
	 } 
	 }






	

}
