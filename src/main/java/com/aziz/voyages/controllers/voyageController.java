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

import com.aziz.voyages.entities.Categorie;
import com.aziz.voyages.entities.voyage;
import com.aziz.voyages.service.voyageService;

import jakarta.validation.Valid;

@Controller
public class voyageController {

    @Autowired
    private voyageService voyageService;

    @GetMapping("/error")
    public String error() {
        return "accessDenied";
    }

    @RequestMapping("/Listevoyages")
    public String listevoyages(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        Page<voyage> voyages = voyageService.getAllvoyagesParPage(page, size);
        modelMap.addAttribute("voyages", voyages);
        modelMap.addAttribute("pages", new int[voyages.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listevoyages";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("voyage", new voyage());
        List<Categorie> categories = voyageService.getAllCategories();
        modelMap.addAttribute("categories", categories);
        return "formvoyage";
    }

    @RequestMapping("/savevoyage")
    public String savevoyage(@Valid @ModelAttribute("voyage") voyage voyage, BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        int currentPage;
        boolean isNew = voyage.getIdvoyage() == null;
        if (bindingResult.hasErrors()) {
            return "formvoyage";
        }
        voyageService.savevoyage(voyage);
        if (isNew) {
            Page<voyage> voyages = voyageService.getAllvoyagesParPage(page, size);
            currentPage = voyages.getTotalPages() - 1;
        } else {
            currentPage = page;
        }
        return ("redirect:/Listevoyages?page=" + currentPage + "&size=" + size);
    }

    @RequestMapping("/supprimervoyage")
    public String supprimervoyage(@RequestParam("id") Long id,
            ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        voyageService.deletevoyageById(id);
        Page<voyage> voyages = voyageService.getAllvoyagesParPage(page, size);
        modelMap.addAttribute("voyages", voyages);
        modelMap.addAttribute("pages", new int[voyages.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listevoyages";
    }

    @RequestMapping("/modifiervoyage")
    public String editervoyage(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        voyage voyage = voyageService.getvoyage(id);
        List<Categorie> categories = voyageService.getAllCategories();
        modelMap.addAttribute("voyage", voyage);
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formvoyage";
}}
