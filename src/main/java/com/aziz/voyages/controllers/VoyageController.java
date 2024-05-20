package com.aziz.voyages.controllers;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aziz.voyages.entities.Type;
import com.aziz.voyages.entities.Voyage;
import com.aziz.voyages.service.VoyageService;


import jakarta.validation.Valid;

@Controller
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @GetMapping("/error")
    public String error() {
        return "accessDenied";
    }

    @RequestMapping("/Listevoyages")
    public String listevoyages(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Voyage> Voyages = voyageService.getAllVoyagesParPage(page, size);
        modelMap.addAttribute("voyages", Voyages);
        modelMap.addAttribute("pages", new int[Voyages.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listevoyages";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("voyage", new Voyage());
        List<Type> types = voyageService.getAllTypes();
        modelMap.addAttribute("categories", types);
        return "formvoyage";
    }

    @RequestMapping("/savevoyage")
    public String savevoyage(@Valid @ModelAttribute("voyage") Voyage Voyage, BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        int currentPage;
        boolean isNew = Voyage.getIdvoyage() == null;
        if (bindingResult.hasErrors()) {
            return "formvoyage";
        }
        voyageService.saveVoyage(Voyage);
        if (isNew) {
            Page<Voyage> Voyages = voyageService.getAllVoyagesParPage(page, size);
            currentPage = Voyages.getTotalPages() - 1;
        } else {
            currentPage = page;
        }
        return ("redirect:/Listevoyages?page=" + currentPage + "&size=" + size);
    }

    @RequestMapping("/supprimervoyage")
    public String supprimervoyage(@RequestParam("id") Long id,
            ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        voyageService.deleteVoyageById(id);
        Page<Voyage> Voyages = voyageService.getAllVoyagesParPage(page, size);
        modelMap.addAttribute("voyages", Voyages);
        modelMap.addAttribute("pages", new int[Voyages.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listevoyages";
    }

    @RequestMapping("/modifiervoyage")
    public String editervoyage(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Voyage Voyage = voyageService.getVoyage(id);
        List<Type> types = voyageService.getAllTypes();
        modelMap.addAttribute("voyage", Voyage);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("categories", types);
        
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        
        return "formvoyage";
    }
        @RequestMapping("/updatevoyage")
    	public String updatevoyage(@ModelAttribute("voyage") Voyage Voyage, @RequestParam("date") String date,ModelMap modelMap) throws ParseException
    	{
 
    	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    	Date dateCreation = dateformat.parse(String.valueOf(date));
    	Voyage.setDateCreation(dateCreation);
    	voyageService.updateVoyage(Voyage);
    	List<Voyage> voys = voyageService.getAllVoyages();
    	modelMap.addAttribute("voyages",voys);
    	return "listevoyages";
    	}
    	@GetMapping(value = "/") public String welcome() { return "index";}
    	@Controller
    	public class SecurityController {
    	@GetMapping("/accessDenied")
    	public String error()
    	{
    	return "accessDenied";
    	}
    	}
}
