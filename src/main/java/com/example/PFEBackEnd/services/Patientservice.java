package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Patient;
@Service
public interface Patientservice {
	void savePatient(Patient patient);
	
	
	List<Patient> listPatient();
	void removePatient (Long id);
	public Patient findById(Long id);
	Patient updatepatient(Long id, Patient newpatient);
}
