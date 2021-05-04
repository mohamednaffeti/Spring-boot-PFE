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
import com.example.PFEBackEnd.Entities.Rendez_vous;
import com.example.PFEBackEnd.Repositories.DossierRepository;
import com.example.PFEBackEnd.Repositories.Rendez_vousRepository;
import com.example.PFEBackEnd.services.DossierService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/dossier")
public class DossierController {
	@Autowired
	DossierService dossierservice;
	@Autowired
	DossierRepository dossier;
	@Autowired
	Rendez_vousRepository repordv;
	@GetMapping(value="/listdossiers")
	public List<Dossier> listdossier(){ 
		return dossierservice.getDossierByFiche_patient();
	}
	@PostMapping(value="/add-dossier")
	public void save(@RequestBody Dossier dossier) {
	dossierservice.savedossier(dossier);
	}
	@PutMapping("/update/{id}")
	public Dossier update(@PathVariable(value="id") Long id, @Validated @RequestBody Dossier dossier) {
		return dossierservice.updatedossier(id, dossier);
		

	}
	@DeleteMapping(value="/listdossiers/{id}")
	public void delete(@PathVariable(name="id") Long id ){
		
	    dossierservice.remove(id);
	}
	@PutMapping("/etat/{id}")
	public void setetat(@PathVariable Long id) {
		 dossier.updateetat("partiellement payé", id);
	}
	@PutMapping("/etatdossier/{id}")
	public void setetatdossier(@PathVariable Long id) {
		 dossier.updateetatdossier("Clôturer", id);
	}
	@GetMapping("/rdv/{id}")
	public List<Rendez_vous> getrdv(@PathVariable Long id) {
		Dossier dossier =dossierservice.findById(id);
	    return repordv.selectrdv(dossier);
	}
	
}
