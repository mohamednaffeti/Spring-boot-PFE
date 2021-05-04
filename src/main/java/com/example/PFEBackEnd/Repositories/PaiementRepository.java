package com.example.PFEBackEnd.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.Entities.Paiement;


@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long>{
	
	 @Query("SELECT SUM(p.montant) FROM Paiement p where p.dossier =:dossier")
	  public  Integer selectTotals(Dossier dossier);
	
}
