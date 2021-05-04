package com.example.PFEBackEnd.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.PFEBackEnd.Entities.Rendez_vous;
import com.example.PFEBackEnd.Repositories.Rendez_vousRepository;
import com.example.PFEBackEnd.services.Rendez_vousService;

@Service
public class Rendez_vousServiceImpl implements Rendez_vousService{
@Autowired
Rendez_vousRepository rdvrepository;
	@Override
	public void saverdv(Rendez_vous rendez_vous) {
		rdvrepository.save(rendez_vous);
		
	}

	@Override
	public List<Rendez_vous> listrdv() {
		
		return rdvrepository.findAll();
	}

	@Override
	public void removeRendez_vous(Long id) {
		rdvrepository.deleteById(id);
		
	}

	@Override
	public Rendez_vous findById(Long id) {
		Optional<Rendez_vous>rendez_vous=rdvrepository.findById(id);
		return rendez_vous.isPresent() ? rendez_vous.get() : null;
	}

	@Override
	public Rendez_vous updaterdv(Long id, Rendez_vous rendez_vous) {
		Optional<Rendez_vous>rendez_vous1=rdvrepository.findById(id);
		if (rendez_vous1.isPresent()) {
			Rendez_vous rendez_vous2=rendez_vous1.get();
			rendez_vous2.setDate_rdv(rendez_vous.getDate_rdv());
			rendez_vous2.setDate_debut(rendez_vous.getDate_debut());
			rendez_vous2.setDate_fin(rendez_vous.getDate_fin());
			rendez_vous2.setTache(rendez_vous.getTache());
			rendez_vous2.setCompte_rendu(rendez_vous.getCompte_rendu());
			rendez_vous2.setEtat(rendez_vous.getEtat());
			
			Rendez_vous rendez_vous3=rdvrepository.save(rendez_vous2);
			return rendez_vous3;
			
		}
		return null;
		
	}

}
