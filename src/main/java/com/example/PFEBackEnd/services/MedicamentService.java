package com.example.PFEBackEnd.services;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.PFEBackEnd.Entities.Medicament;

@Service
public interface MedicamentService {
	void savemedicament(Medicament medicament);
    List<Medicament> getmedicaments();
    void remove(Long id);
    public Medicament findById(Long id);
    Medicament updatemedicament(Long id,Medicament medicament);
    public Optional<Medicament> findById_medicament(Long id);
}
