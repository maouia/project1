package com.maouia.tv.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maouia.tv.entities.tv;
import com.maouia.tv.service.tvService;
@Controller
public class tvController {
	@Autowired
	tvService tvService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("tv", new tv());
	return "createTv";
	}
	@RequestMapping("/savetv") 
	public String savetv(@Valid tv tv, BindingResult bindingResult)  
	{ 
		
		if (bindingResult.hasErrors()) return "createTv";
		tvService.savetv(tv); 
		return "createTv"; 
	}

	
	@RequestMapping("/Listetv")
	public String listetvs(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<tv> prods = tvService.getAlltvsParPage(page, size);
		modelMap.addAttribute("tv", prods);
		 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeTv";

	}
	
	@RequestMapping("/supprimertv")
	public String supprimertv(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{
	tvService.deletetvById(id);
	Page<tv> prods = tvService.getAlltvsParPage(page,
			size);
			modelMap.addAttribute("tv", prods);
			modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
	return "listeTv";
	}


	@RequestMapping("/modifiertv")
	public String editertv(@RequestParam("id") Long id,ModelMap modelMap)
	{
	tv p= tvService.gettv(id);
	modelMap.addAttribute("tv", p);
	return "modifierTv";
	}
	@RequestMapping("/updatetv")
	public String updatetv(@ModelAttribute("tv") tv tv,
	@RequestParam("date") String date, ModelMap modelMap) throws ParseException
	{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 tv.setDateCreation(dateCreation);

		 tvService.updatetv(tv);
		 List<tv> prods = tvService.getAlltvs();
		 modelMap.addAttribute("tv", prods);
		return "listeTv";
		}
	
	
}
