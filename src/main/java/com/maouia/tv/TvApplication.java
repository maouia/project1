package com.maouia.tv;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.maouia.tv.entities.tv;
import com.maouia.tv.service.tvService;

@SpringBootApplication
public class TvApplication implements CommandLineRunner{
	@Autowired	
	tvService tvService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(TvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*tvService.savetv(new tv("maxwel",555.5,new Date()));
		tvService.savetv(new tv("aaaa",7841.89,new Date()));
		tvService.savetv(new tv("ccccc",45123.569,new Date()));
	*/
		repositoryRestConfiguration.exposeIdsFor(tv.class);
	
	}

}
