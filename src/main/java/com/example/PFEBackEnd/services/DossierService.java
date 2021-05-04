package com.example.PFEBackEnd.services;



import java.util.List;


import org.springframework.stereotype.Service;


import com.example.PFEBackEnd.Entities.Dossier;



@Service
public interface DossierService {
	 void savedossier(Dossier dossier);
     List<Dossier> getDossierByFiche_patient();
     void remove(Long id);
     public Dossier findById(Long id);
     Dossier updatedossier(Long id,Dossier dossier);
     
}
