package com.aziz.voyages.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.aziz.voyages.entities.Type;
import com.aziz.voyages.entities.Voyage;

public interface VoyageService {
    Voyage saveVoyage(Voyage v);

    Voyage updateVoyage(Voyage v);

    void deleteVoyage(Voyage v);

    void deleteVoyageById(Long id);

    Voyage getVoyage(Long id);

    List<Voyage> getAllVoyages();

    Page<Voyage> getAllVoyagesParPage(int page, int size);

    List<Voyage> findByNomVoyage(String nom);

    List<Voyage> findByNomVoyageContains(String nom);

    List<Voyage> findByNomPrix(String nom, Double prix);

    List<Voyage> findByType(Type type);

    List<Voyage> findByTypeId(Long id);

    List<Voyage> findByOrderByNomVoyageAsc();

    List<Voyage> trierVoyagesNomsPrix();

    List<Type> getAllTypes();
}
