package com.example.PFEBackEnd.servicesImpl;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Patient;
import com.example.PFEBackEnd.Repositories.PatientRepository;
import com.example.PFEBackEnd.services.Patientservice;
@Service
public class PatientImpl implements Patientservice{
@Autowired
 PatientRepository patientRepository;
	@Override
	public void savePatient(Patient patient) {
		patientRepository.save(patient);
		
	}
	@Override
	public Patient findById(Long id) {
		Optional<Patient> patient = patientRepository.findById(id);
		return patient.isPresent() ? patient.get() : null;
	}

	

	@Override
	public List<Patient> listPatient() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public void removePatient(Long id) {
		patientRepository.deleteById(id);
		
	}
	@Override
	public Patient updatepatient(Long id, Patient newpatient) {
		Optional<Patient>patient=patientRepository.findById(id);
		if(patient.isPresent()) {
			Patient patient1=patient.get();
			patient1.setNom_patient(newpatient.getNom_patient());
			patient1.setPrenom_patient(newpatient.getPrenom_patient());
			patient1.setNum_tel1(newpatient.getNum_tel1());
			patient1.setNum_tel2(newpatient.getNum_tel2());
			patient1.setEmail(newpatient.getEmail());
			patient1.setAdresse(newpatient.getAdresse());
			patient1.setSexe(newpatient.getSexe());
			patient1.setCin(newpatient.getCin());
			patient1.setCnam(newpatient.getCnam());
			patient1.setAdre_par_qui(newpatient.getAdre_par_qui());
			patient1.setDate_naissance(newpatient.getDate_naissance());
			
			Patient p1=patientRepository.save(patient1);
			return p1;
		}
		return null;
	}
	
	
	

	

}
