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
import com.example.PFEBackEnd.Repositories.Rendez_vousRepository;
import com.example.PFEBackEnd.services.Rendez_vousService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/rendez_vous")
public class Rendez_vousController {
@Autowired
Rendez_vousService redvservice;
@Autowired
Rendez_vousRepository rdvrepo;
@GetMapping(value="/listrendez_vous")
public List<Rendez_vous> listrendez_vous(){
	return redvservice.listrdv();
}
@PostMapping(value="/add-rdv")
public void save(@RequestBody Rendez_vous rendez_vous) {
redvservice.saverdv(rendez_vous);
}
@PutMapping("/update/{id}")
public Rendez_vous update(@PathVariable(value="id") Long id, @Validated @RequestBody Rendez_vous rendez_vous) {
	return redvservice.updaterdv(id, rendez_vous);
	

}
@DeleteMapping(value="/listrendez_vous/{id}")
public void delete(@PathVariable(name="id") Long id ){
	
    redvservice.removeRendez_vous(id);
}
@GetMapping("/montant/{date}")
public List<Rendez_vous> getForecastTotals(@PathVariable String date) {
	
    return rdvrepo.select(date);
}
@PutMapping("/etatrdv/{id}")
public void etatrdv(@PathVariable Long id) {
	System.out.println("okkkkkkkkkk");
	 rdvrepo.updateetatrdv("Salle d'attente", id);
}

}
