package com.example.PFEBackEnd.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Utilisateur;
import com.example.PFEBackEnd.Repositories.UtilisateurRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
UtilisateurRepository utilisateurRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> user = utilisateurRepository.findByUsername(username);
				user.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
				//System.out.println(username);

		return user.map(MyUserDetails::new).get();
	}

}
