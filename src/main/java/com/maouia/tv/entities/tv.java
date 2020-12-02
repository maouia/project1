package com.maouia.tv.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class tv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idtv;
	
	@NotNull 
	@Size (min = 4,max = 15) 
	private String nomtv;
	
	@Min(value = 10) 
	 @Max(value = 10000)
	private Double prixtv;
	
	@Temporal(TemporalType.DATE) 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	
	public long getIdtv() {
		return idtv;
	}
	public void setIdtv(long idtv) {
		this.idtv = idtv;
	}
	public String getNomtv() {
		return nomtv;
	}
	public void setNomtv(String nomtv) {
		this.nomtv = nomtv;
	}
	public Double getPrixtv() {
		return prixtv;
	}
	public void setPrixtv(Double prixtv) {
		this.prixtv = prixtv;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	@Override
	public String toString() {
		return "tvs [idtv=" + idtv + ", nomtv=" + nomtv + ", prixtv=" + prixtv + ", dateCreation=" + dateCreation + "]";
	}
	
	
	
	
	
	public tv() {
		super();
	}
	
	
	public tv(String nomtv, Double prixtv, Date dateCreation) {
		super();
		this.nomtv = nomtv;
		this.prixtv = prixtv;
		this.dateCreation = dateCreation;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
