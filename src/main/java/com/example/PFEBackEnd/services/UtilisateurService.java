package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Soins;
import com.example.PFEBackEnd.Entities.Utilisateur;

@Service
public interface UtilisateurService {
	List<Utilisateur> listusers();
	public Utilisateur findById(Long id);
    Utilisateur updateuser(Long id,Utilisateur user);
    Utilisateur updatepass(Long id ,Utilisateur user);
    void remove(Long id);
}
