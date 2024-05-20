package com.aziz.voyages.entities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data

@AllArgsConstructor
@Entity
public class Type {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "type")
	
	private List<Voyage> Voyages;

	public Type() {
	}

	public Type(String nomCat, String descriptionCat, List<Voyage> Voyages) {
		super();
		this.nomCat = nomCat;
		this.descriptionCat = descriptionCat;
		this.Voyages = Voyages;
	}

	public Long getIdCat() {
		return idCat;
	}

	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public String getDescriptionCat() {
		return descriptionCat;
	}

	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}

	public List<Voyage> getvoyages() {
		return Voyages;
	}

	public void setvoyages(List<Voyage> Voyages) {
		this.Voyages = Voyages;
	}
}