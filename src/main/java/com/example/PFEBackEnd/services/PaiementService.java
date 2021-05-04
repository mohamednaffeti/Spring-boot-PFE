package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.Entities.Paiement;

@Service
public interface PaiementService {
void savePaiement(Paiement paiement);
	
void remove(Long id);
List<Paiement> listPaiement();
public Paiement findById(Long id);
Paiement updatepaiement(Long id,Paiement paiement);
}
