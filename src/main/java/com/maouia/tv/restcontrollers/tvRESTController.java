package com.maouia.tv.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maouia.tv.entities.tv;
import com.maouia.tv.service.tvService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class  tvRESTController {
	
	@Autowired
	tvService tvService;
	
	@RequestMapping(method=RequestMethod.GET)
	List<tv> getAlltvs()
	{
		return tvService.getAlltvs();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET) 
	public tv gettvById(@PathVariable("id") Long id) { 
	return tvService.gettv(id); 
	 }
	
	@RequestMapping(method = RequestMethod.POST) 
	public tv createtv(@RequestBody tv tv) { 
	return tvService.savetv(tv); 
	}
	
	@RequestMapping(method = RequestMethod.PUT) 
	public tv updatetv(@RequestBody tv tv) { 
	return tvService.updatetv(tv); 
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE) 
	public void deletetv(@PathVariable("id") Long id) 
	{ 
	tvService.deletetvById(id); 
	}

	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET) 
	public List<tv> gettvsByCatId(@PathVariable("idCat") Long idCat) 
	{ 
		return tvService.findByCategorieIdCat(idCat); 
	}

	

	
}
