package com.example.PFEBackEnd.Repositories;




import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.PFEBackEnd.Entities.Dossier;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long>{
	@Transactional
    @Modifying
    @Query(value = "UPDATE Dossier d set etat_paiement=:etat where d.id_dossier = :id",
            nativeQuery = true)
void updateetat(@Param("etat") String etat, @Param("id") Long id);
	@Transactional
    @Modifying
    @Query(value = "UPDATE Dossier d set etat_dossier=:etat where d.id_dossier = :id",
            nativeQuery = true)
void updateetatdossier(@Param("etat") String etat, @Param("id") Long id);
	
	@Query("SELECT d.tarification FROM Dossier d where d.id_dossier =:id")
	  public  int selectMontant(Long id);

}
