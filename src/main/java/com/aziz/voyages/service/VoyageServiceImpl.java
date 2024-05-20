package com.aziz.voyages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aziz.voyages.entities.Type;
import com.aziz.voyages.entities.Voyage;
import com.aziz.voyages.repos.TypeRepository;
import com.aziz.voyages.repos.VoyageRepository;

@Service
public class VoyageServiceImpl implements VoyageService {

    @Autowired
    VoyageRepository voyageRepository;
    
    @Autowired
    TypeRepository typeRepository;

    @Override
    public Voyage saveVoyage(Voyage v) {
        return voyageRepository.save(v);
    }

    @Override
    public Voyage updateVoyage(Voyage v) {
        return voyageRepository.save(v);
    }

    @Override
    public void deleteVoyage(Voyage v) {
        voyageRepository.delete(v);
    }

    @Override
    public void deleteVoyageById(Long id) {
        voyageRepository.deleteById(id);
    }

    @Override
    public Voyage getVoyage(Long id) {
        return voyageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    @Override
    public Page<Voyage> getAllVoyagesParPage(int page, int size) {
        return voyageRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Voyage> findByNomVoyage(String nom) {
        return voyageRepository.findByNomVoyage(nom);
    }

    @Override
    public List<Voyage> findByNomVoyageContains(String nom) {
        return voyageRepository.findByNomVoyageContains(nom);
    }

//    @Override
//    public List<Voyage> findByNomPrix(String nom, Double prix) {
//        return voyageRepository.findByNomprix(nom, prix.intValue()); // Convert Double to int for prix
//    }

//    @Override
//    public List<Voyage> findByType(Type type) {
//        return voyageRepository.findByType(type);
//    }
//
//    @Override
//    public List<Voyage> findByTypeId(Long id) {
//        return voyageRepository.findByTypeId(id);
//    }

    @Override
    public List<Voyage> findByOrderByNomVoyageAsc() {
        return voyageRepository.findByOrderByNomVoyageAsc();
    }

    @Override
    public List<Voyage> trierVoyagesNomsPrix() {
        return voyageRepository.trierVoyagesNomsprix();
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

	@Override
	public List<Voyage> findByType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voyage> findByTypeId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voyage> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}
}
