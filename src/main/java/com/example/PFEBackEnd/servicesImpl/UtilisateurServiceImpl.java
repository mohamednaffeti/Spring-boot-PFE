package com.example.PFEBackEnd.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Soins;
import com.example.PFEBackEnd.Entities.Utilisateur;
import com.example.PFEBackEnd.Repositories.UtilisateurRepository;
import com.example.PFEBackEnd.services.UtilisateurService;
@Service
public class UtilisateurServiceImpl implements UtilisateurService{
@Autowired
UtilisateurRepository userrepo;
@Autowired
PasswordEncoder encoder;
	@Override
	public List<Utilisateur> listusers() {
		return userrepo.findAll();
	}
	
	
	
	@Override
	public Utilisateur findById(Long id) {
		Optional<Utilisateur>user=userrepo.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	
	
	@Override
	public Utilisateur updateuser(Long id, Utilisateur user) {
		Optional<Utilisateur>user1=userrepo.findById(id);
		if(user1.isPresent()) {
			
			Utilisateur user2=user1.get();
			//BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(16);
			//String encodedPassword = encoder.encode(user.getPassword());
			user2.setEmail(user.getEmail());
			user2.setNom(user.getNom());
			user2.setPrenom(user.getPrenom());
			user2.setUsername(user.getUsername());
			user2.setNumtel(user.getNumtel());
			user2.setRole(user.getRole());
			//user2.setPassword(encodedPassword);
			Utilisateur user3=userrepo.save(user2);
			return user3;
			
		}
		return null;
	}
	
	@Override
	public Utilisateur updatepass(Long id, Utilisateur user) {
		Optional<Utilisateur>user1=userrepo.findById(id);
		if(user1.isPresent()) {
			
			Utilisateur user2=user1.get();
			//BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
			//String encodedPassword = encoder.encode(user.getPassword());
			user2.setEmail(user.getEmail());
			user2.setNom(user.getNom());
			user2.setPrenom(user.getPrenom());
			user2.setUsername(user.getUsername());
			user2.setNumtel(user.getNumtel());
			user2.setRole(user.getRole());
			user2.setPassword(encoder.encode(user.getPassword()));
			Utilisateur user3=userrepo.save(user2);
			return user3;
			
		}
		return null;
	}
	@Override
	public void remove(Long id) {
		userrepo.deleteById(id);
	}

}
