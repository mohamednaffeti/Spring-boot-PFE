package com.example.PFEBackEnd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.Entities.Paiement;
import com.example.PFEBackEnd.Repositories.DossierRepository;
import com.example.PFEBackEnd.Repositories.PaiementRepository;
import com.example.PFEBackEnd.services.DossierService;
import com.example.PFEBackEnd.services.PaiementService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/paiement")
public class PaiementController {
	@Autowired
	PaiementService paiementServ;
	@Autowired
	PaiementRepository repo;
	@Autowired
	DossierRepository dossierRepo;
	@GetMapping(value="/listpaiements")
	public List<Paiement> listpaiement(){ 
		return paiementServ.listPaiement();
	}
	@PostMapping(value="/add-paiement")
	public void save(@RequestBody Paiement paiement) {
	paiementServ.savePaiement(paiement);
	}
	@GetMapping("/montant/{id}")
	public Integer getForecastTotals(@PathVariable Long id) {
		Dossier dossier =dossierRepo.findById(id).get();
	    return repo.selectTotals(dossier);
	}
	@DeleteMapping(value="/listpaiements/{id}")
	public void delete(@PathVariable(name="id") Long id ){
		
	    paiementServ.remove(id);
	}
	@PutMapping("/update/{id}")
	public Paiement update(@PathVariable(value="id") Long id, @Validated @RequestBody Paiement paiement) {
		return paiementServ.updatepaiement(id, paiement);
		

	}
	
	
}
