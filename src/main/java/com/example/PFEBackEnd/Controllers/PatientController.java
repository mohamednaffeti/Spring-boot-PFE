package com.example.PFEBackEnd.Controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.example.PFEBackEnd.Entities.Patient;
import com.example.PFEBackEnd.Repositories.PatientRepository;
import com.example.PFEBackEnd.services.Patientservice;




@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/patient")
public class PatientController {
@Autowired
Patientservice patientservice;

@GetMapping(value="/listpatient")
public List<Patient> listPatient(){
	return patientservice.listPatient();
}
//@PreAuthorize("hasRole('SECRETAIRE')")
@PostMapping(value="/add-patient")
public void save(@RequestBody Patient p) {
	patientservice.savePatient(p);
}
//@PreAuthorize("hasRole('secretaire')")
@PutMapping("/update/{id}")
public Patient update(@PathVariable(value="id") Long id, @Validated @RequestBody Patient newpatient) {
	return patientservice.updatepatient(id,newpatient);
	

	
}
@DeleteMapping(value="/listpatient/{id}")
public void delete(@PathVariable(name="id") Long id ){
	
    patientservice.removePatient(id);
}

}
