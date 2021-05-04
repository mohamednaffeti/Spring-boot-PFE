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


import com.example.PFEBackEnd.Entities.Medicament;
import com.example.PFEBackEnd.services.MedicamentService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/medicament")
public class MedicamentController {
@Autowired
MedicamentService medserv;
@GetMapping(value="/listmedicaments")
public List<Medicament> listmedicaments(){ 
	return medserv.getmedicaments();
}
@PostMapping(value="/add-medicament")
public void save(@RequestBody Medicament medicament) {
medserv.savemedicament(medicament);
}
@PutMapping("/update/{id}")
public Medicament update(@PathVariable(value="id") Long id, @Validated @RequestBody Medicament medicament) {
	return medserv.updatemedicament(id, medicament);
	

}
@DeleteMapping(value="/listmedicaments/{id}")
public void delete(@PathVariable(name="id") Long id ){
	
    medserv.remove(id);
}

}
