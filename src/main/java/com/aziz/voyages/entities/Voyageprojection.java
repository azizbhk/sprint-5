package com.aziz.voyages.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomvoy", types = { Voyage.class })
public interface Voyageprojection {
	public String getNomvoyage();
}