package com.aziz.voyages.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity

public class Voyage {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idvoyage;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomVoyage;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixVoyage;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	@ManyToOne
	private Type type;
	public Type gettype() {
		return type;
	}
	public void settype(Type type) {
		this.type = type;
	}
	public Long getIdvoyage() {
		return idvoyage;
	}
	public Voyage() {
		super();
	
	}
	public Voyage(String nomVoyage, Double prixVoyage, Date dateCreation) {
		super();
		this.nomVoyage = nomVoyage;
		this.prixVoyage = prixVoyage;
		this.dateCreation = dateCreation;
	}
	public void setIdvoyage(Long idvoyage) {
		this.idvoyage = idvoyage;
	}
	public String getnomVoyage() {
		return nomVoyage;
	}
	public void setnomVoyage(String nomVoyage) {
		this.nomVoyage = nomVoyage;
	}
	public Double getprixVoyage() {
		return prixVoyage;
	}
	public void setprixVoyage(Double prixVoyage) {
		this.prixVoyage = prixVoyage;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "voyage [idvoyage=" + idvoyage + ", nomVoyage=" + nomVoyage + ", prixVoyage=" + prixVoyage
				+ ", dateCreation=" + dateCreation + "]";
	}

	
	

}
