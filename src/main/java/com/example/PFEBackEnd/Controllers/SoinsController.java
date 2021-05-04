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

import com.example.PFEBackEnd.Entities.Soins;
import com.example.PFEBackEnd.services.SoinsService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/soins")
public class SoinsController {
	@Autowired
	SoinsService soinsservice;
	@GetMapping(value="/listsoins")
	public List<Soins> listsoins(){
		return soinsservice.listsoins();
		
	}
	@PostMapping(value="/add-soins")
	public void save(@RequestBody Soins soin) {
	soinsservice.savesoins(soin);	
	}
	@PutMapping("/update/{id}")
	public Soins update(@PathVariable(value="id") Long id, @Validated @RequestBody Soins soin) {
		return soinsservice.updatesoins(id, soin);
		

	}
	@DeleteMapping(value="/listsoins/{id}")
	public void delete(@PathVariable(name="id") Long id ){
		
	    soinsservice.remove(id);
	}
}
