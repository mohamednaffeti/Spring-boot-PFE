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

import com.example.PFEBackEnd.Entities.Charges;

import com.example.PFEBackEnd.services.ChargeService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/charge")
public class ChargeController {
@Autowired
ChargeService chargeserv;
@GetMapping(value="/listcharges")
public List<Charges> listcharge(){ 
	return chargeserv.listcharges();
}

@PostMapping(value="/add-charge")
public void save(@RequestBody Charges charge) {
chargeserv.saveCharge(charge);
}
@PutMapping("/update/{id}")
public Charges update(@PathVariable(value="id") Long id, @Validated @RequestBody Charges charge) {
	return chargeserv.updatecharge(id, charge);
	

}
@DeleteMapping(value="/listcharges/{id}")
public void delete(@PathVariable(name="id") Long id ){
	
    chargeserv.removeCharge(id);
}

}
