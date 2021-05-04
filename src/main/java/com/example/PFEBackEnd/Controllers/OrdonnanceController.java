package com.example.PFEBackEnd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PFEBackEnd.Entities.Ordonnance;
import com.example.PFEBackEnd.services.OrdonnanceService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/ordonnance")
public class OrdonnanceController {
	@Autowired
	OrdonnanceService ordoserv;
	
	@GetMapping(value="/list")
	public List<Ordonnance> listordonnance(){ 
		return ordoserv.getordonnances();
	}
	@PostMapping(value="/add")
	public void save(@RequestBody Ordonnance ordonnance) {
	ordoserv.saveordonnace(ordonnance);;
	}
	@DeleteMapping(value="/list/{id}")
	public void delete(@PathVariable(name="id") Long id ){
		
	    ordoserv.remove(id);
	}
}
