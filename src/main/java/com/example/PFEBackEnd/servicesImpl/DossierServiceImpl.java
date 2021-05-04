package com.example.PFEBackEnd.servicesImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.Repositories.DossierRepository;
import com.example.PFEBackEnd.services.DossierService;

@Service
public class DossierServiceImpl implements DossierService{
	@Autowired
	DossierRepository dossierRepository;
	
	@Override
	public void savedossier(Dossier dossier) {
		dossierRepository.save(dossier);
	}

	@Override
	public List<Dossier> getDossierByFiche_patient() {
		
		return dossierRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		dossierRepository.deleteById(id);
		
	}

	@Override
	public Dossier findById(Long id) {
		Optional<Dossier>dossier=dossierRepository.findById(id);
		return dossier.isPresent() ? dossier.get() : null;
	}

	@Override
	public Dossier updatedossier(Long id, Dossier dossier) {
		Optional<Dossier>dossier1=dossierRepository.findById(id);
		if(dossier1.isPresent()) {
			Dossier dossier2=dossier1.get();
			dossier2.setNom_dossier(dossier.getNom_dossier());
			//dossier2.setDate_creation_dossier(dossier.getDate_creation_dossier());
			//dossier2.setEtat_paiement(dossier.getEtat_paiement());
			dossier2.setDent(dossier.getDent());
			dossier2.setSoin(dossier.getSoin());
			//dossier2.setPatient(dossier.getPatient());
			dossier2.setTarification(dossier.getTarification());
			Dossier dossier3=dossierRepository.save(dossier2);
			return dossier3;
		}
		return null;
	}
}
