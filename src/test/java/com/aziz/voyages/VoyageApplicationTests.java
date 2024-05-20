//package com.aziz.voyages;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//
//import com.aziz.voyages.entities.Type;
//import com.aziz.voyages.entities.Voyage;
//import com.aziz.voyages.repos.VoyageRepository;
//import com.aziz.voyages.service.voyageService;
//@SpringBootTest
//class VoyageApplicationTests {
//@Autowired
//private VoyageRepository VoyageRepository;
//@Autowired
//private voyageService voyageService;
//@Test
//public void testCreatevoyage() {
//Voyage voy = new Voyage("turkey",2200.500,new Date());
//VoyageRepository.save(voy);
//}
//
//
//@Test
//public void testFindvoyage()
//{
//Voyage v = VoyageRepository.findById(1L).get();
//System.out.println(v);
//}
//@Test
//public void testUpdatevoyage()
//{
//Voyage v = VoyageRepository.findById(1L).get();
//v.setPrixvoyage(1000.0);
//VoyageRepository.save(v);
//}
//@Test
//public void testDeletevoyage()
//{
//VoyageRepository.deleteById(1L);;
//}
//@Test
//public void testListerTousvoyages()
//{
//List<Voyage> voys = VoyageRepository.findAll();
//for (Voyage v : voys)
//
//System.out.println(v);
//
//
//} 
//@Test
//public void testFindvoyageByNom()
//{
//List<Voyage> voys = VoyageRepository.findByNomvoyage("turkey");
//for (Voyage v : voys)
//
//System.out.println(v);
//}
//
//@Test
//public void testFindvoyageByNomContains() {
//	List<Voyage> voys = VoyageRepository.findByNomvoyageContains("t");
//	for (Voyage v : voys)
//
//		System.out.println(v);
//}
//@Test
//public void testfindByNomPrix()
//{
//List<Voyage> voys = VoyageRepository.findByNomPrix("turkey", 1000.0);
//for (Voyage v : voys)
//{
//System.out.println(v);
//}
//}
//@Test
//public void testfindByCategorie()
//{
//Type cat = new Type();
//cat.setIdCat(1L);
//List<Voyage> voys = VoyageRepository.findByCategorie(cat);
//for (Voyage v : voys)
//{
//System.out.println(v);
//}
//}
//@Test
//public void findByCategorieIdCat()
//{
//List<Voyage> voys = VoyageRepository.findByCategorieIdCat(1L);
//for (Voyage v : voys)
//{
//System.out.println(v);
//}
// }
//
//	@Test
//	public void testfindByOrderByNomvoyageAsc() {
//		List<Voyage> voys = VoyageRepository.findByOrderByNomvoyageAsc();
//		for (Voyage v : voys) {
//			System.out.println(v);
//		}
//	}
//
//	@Test
//	public void testTriervoyagesNomsPrix() {
//		List<Voyage> voys = VoyageRepository.triervoyagesNomsPrix();
//		for (Voyage v : voys) {
//			System.out.println(v);
//		}
//	}
//
//	@Test
//public void testFindByNomvoyageContains()
//{
//	
//Page<Voyage> voys = voyageService.getAllvoyagesParPage(0,2);
//System.out.println(voys.getSize());
//System.out.println(voys.getTotalElements());
//System.out.println(voys.getTotalPages());
//voys.getContent().forEach(v -> {System.out.println(v.toString());
// });
//
//}}
//
//
