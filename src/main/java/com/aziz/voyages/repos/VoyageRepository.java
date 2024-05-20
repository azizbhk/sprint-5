package com.aziz.voyages.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aziz.voyages.entities.Voyage;

import aj.org.objectweb.asm.Type;



@RepositoryRestResource(path = "rest")
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
	List<Voyage> findByNomVoyage(String nom);
	List<Voyage> findByNomVoyageContains(String nom);
	
	//@Query("select p from Voyage p where p.nomVoyage like %?1 and p.prixVoyage > ?2")
	//List<Voyage> findByNomprix (String nom, int prix);
	
//	@Query("select p from Voyage p where p.nomVoyage like %:nom and p.prixVoyage > :prix")
//	List<Voyage> findByNomprix (@Param("nom") String nom,@Param("prix") int prix);
//	
////	@Query("select p from Voyage p where p.type = ?1")
//	List<Voyage> findBytype(Type type);
////	
//	@Query("select e from Voyage e where e.type.idtype = :id")
//	List<Voyage> findBytypeId(@Param("id") Long id);


	List<Voyage> findByOrderByNomVoyageAsc();
	
	@Query("select p from Voyage p order by p.nomVoyage ASC, p.prixVoyage DESC")
	List<Voyage> trierVoyagesNomsprix();
}