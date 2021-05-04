package com.example.PFEBackEnd.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PFEBackEnd.Entities.Paiement;
import com.example.PFEBackEnd.Repositories.DossierRepository;
import com.example.PFEBackEnd.Repositories.PaiementRepository;
import com.example.PFEBackEnd.services.PaiementService;
@Service
public class PaiementServiceImpl implements PaiementService{
@Autowired
PaiementRepository paiementRepo;
@Autowired 
DossierRepository dossierRepo;
	@Override
	public void savePaiement(Paiement paiement) {
		paiementRepo.save(paiement);
		int somme=paiementRepo.selectTotals(paiement.getDossier());
		int somme1=dossierRepo.selectMontant(paiement.getDossier().getId_dossier());
		
		System.out.println(somme);
		System.out.println(somme1);
		
		if(somme<somme1) {
			dossierRepo.updateetat("partiellement payé", paiement.getDossier().getId_dossier());
		}else {
			dossierRepo.updateetat("totalement payé", paiement.getDossier().getId_dossier());
		}
		
		
		
		
	}

	@Override
	public List<Paiement> listPaiement() {
		
		return paiementRepo.findAll();
	}

	@Override
	public void remove(Long id) {
		Paiement paiement =paiementRepo.findById(id).get();
		paiementRepo.deleteById(id);
		
		Integer somme=paiementRepo.selectTotals(paiement.getDossier());
		int somme1=dossierRepo.selectMontant(paiement.getDossier().getId_dossier());
		System.out.println(somme);
	 if (somme==null) {
			dossierRepo.updateetat("totalement impayé", paiement.getDossier().getId_dossier());
		}
	 else if(somme>0&&somme<somme1) {
			dossierRepo.updateetat("partiellement payé", paiement.getDossier().getId_dossier());
		}else if(somme==somme1) {
			dossierRepo.updateetat("totalement payé", paiement.getDossier().getId_dossier());
		}
		
	}

	@Override
	public Paiement updatepaiement(Long id, Paiement paiement) {
		Optional<Paiement>paiement1=paiementRepo.findById(id);
		if(paiement1.isPresent()) {
			Paiement paiement2=paiement1.get();
			paiement2.setMode_paiement(paiement.getMode_paiement());
			paiement2.setMontant(paiement.getMontant());
			paiement2.setTache(paiement.getTache());
			//paiement2.setDossier(paiement.getDossier());
			
			Paiement paiement3=paiementRepo.save(paiement2);
			Paiement paiement4 =paiementRepo.findById(id).get();
			Integer somme=paiementRepo.selectTotals(paiement4.getDossier());
			int somme1=dossierRepo.selectMontant(paiement4.getDossier().getId_dossier());
			System.out.println(somme);
			System.out.println(somme1);
			
			if (somme==null) {
				dossierRepo.updateetat("totalement impayé", paiement4.getDossier().getId_dossier());
			}
		 else if(somme>0&&somme<somme1) {
				dossierRepo.updateetat("partiellement payé", paiement4.getDossier().getId_dossier());
			}else if(somme==somme1) {
				dossierRepo.updateetat("totalement payé", paiement4.getDossier().getId_dossier());
			}
			
			return paiement3;
		}
		return null;
	}

	@Override
	public Paiement findById(Long id) {
		Optional<Paiement>paiement=paiementRepo.findById(id);
		return paiement.isPresent() ? paiement.get() : null;
	}

}
