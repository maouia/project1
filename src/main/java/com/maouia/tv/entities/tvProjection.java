package com.maouia.tv.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { tv.class }) 
public interface tvProjection { 
public String getNomtv(); 
} 

