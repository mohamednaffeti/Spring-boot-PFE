package com.example.PFEBackEnd.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.Entities.Rendez_vous;
@Repository
public interface Rendez_vousRepository extends JpaRepository<Rendez_vous, Long>{
	 @Query("SELECT r FROM Rendez_vous r where r.date_rdv =:date")
	  public List<Rendez_vous> select(String date);
	  
	  @Query("SELECT r FROM Rendez_vous r where r.dossier =:dossier")
	  public  List<Rendez_vous> selectrdv(Dossier dossier);
	  
	  
	  @Transactional
	    @Modifying
	  @Query(value = "UPDATE Rendez_vous r set etat=:etat where r.id_rdv = :id",
	            nativeQuery = true)
	void updateetatrdv(@Param("etat") String etat, @Param("id") Long id);
}
