package com.example.PFEBackEnd.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.Entities.Medicament;
import com.example.PFEBackEnd.Repositories.MedicamentRepository;
import com.example.PFEBackEnd.services.MedicamentService;
@Service
public class MedicamentServiceImpl implements MedicamentService{
@Autowired
MedicamentRepository medrepo;
	@Override
	public void savemedicament(Medicament medicament) {
		medrepo.save(medicament);
		
	}

	@Override
	public List<Medicament> getmedicaments() {
		return medrepo.findAll();
	}

	@Override
	public void remove(Long id) {
		medrepo.deleteById(id);
		
	}

	@Override
	public Medicament findById(Long id) {
		Optional<Medicament>medicament=medrepo.findById(id);
		return medicament.isPresent() ? medicament.get() : null;
	}

	@Override
	public Medicament updatemedicament(Long id, Medicament medicament) {
		Optional<Medicament>medicament1=medrepo.findById(id);
		if(medicament1.isPresent()) {
			Medicament medicament2=medicament1.get();
			medicament2.setCode(medicament.getCode());
			medicament2.setLibelle(medicament.getLibelle());
			medicament2.setNbr_fois(medicament.getNbr_fois());
			Medicament medicament3=medrepo.save(medicament2);
			return medicament3;
		}
		return null;
	}

	@Override
	public Optional<Medicament> findById_medicament(Long id) {
		
		return medrepo.findById(id);
		
	}

}
