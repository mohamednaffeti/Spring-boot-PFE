package com.example.PFEBackEnd.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Utilisateur;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Optional <Utilisateur> findByUsername(String username);
	Boolean existsByUsername(String username);
}
