package com.aziz.voyages.RESTControllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.voyages.entities.Voyage;
import com.aziz.voyages.service.VoyageService;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class VoyageRESTController {
	@Autowired
	VoyageService voyageService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Voyage> getAllvoyages() {
		return voyageService.getAllVoyages();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Voyage getvoyageById(@PathVariable("id") Long id) {
		return voyageService.getVoyage(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Voyage createvoyage(@RequestBody Voyage Voyage) {
		return voyageService.saveVoyage(Voyage);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Voyage updatevoyage(@RequestBody Voyage Voyage) {
		return voyageService.updateVoyage(Voyage);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletevoyage(@PathVariable("id") Long id)
	{
	voyageService.deleteVoyageById(id);
	}
	@RequestMapping(value="/voyagescat/{idCat}",method = RequestMethod.GET)
	public List<Voyage> getvoyagesByCatId(@PathVariable("idCat") Long idCat) {
	return voyageService.findByTypeId(idCat);
	}

	
}
