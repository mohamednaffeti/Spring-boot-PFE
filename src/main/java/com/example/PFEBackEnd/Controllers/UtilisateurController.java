package com.example.PFEBackEnd.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.PFEBackEnd.Config.MyUserDetails;
import com.example.PFEBackEnd.Entities.Soins;
import com.example.PFEBackEnd.Entities.Utilisateur;
import com.example.PFEBackEnd.Repositories.UtilisateurRepository;
import com.example.PFEBackEnd.Request.LoginRequest;
import com.example.PFEBackEnd.Request.RegisterRequest;
import com.example.PFEBackEnd.Security.JwtTokenUtil;
import com.example.PFEBackEnd.domain.JwtResponse;
import com.example.PFEBackEnd.domain.Response;
import com.example.PFEBackEnd.services.UtilisateurService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtilisateurController {
	@Autowired
	UtilisateurService userserv;
	@Autowired
	PasswordEncoder encoder;
	@Autowired 	private AuthenticationManager authenticationManager;
	@Autowired	JwtTokenUtil jwtUtils;
	@Autowired UtilisateurRepository userRepository;
	
	
@GetMapping("/pwd")
public ResponseEntity<?> genPwd() throws Exception{
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(16);
	String encodedPassword = encoder.encode("12345678");
	return ResponseEntity.ok(new Response(encodedPassword));
}


@PostMapping("/users")
public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
	if (userRepository.existsByUsername(signUpRequest.getUsername())) {
		return ResponseEntity
				.badRequest()
				.body(new Response("Error: Username is already taken!"));
	}

	System.out.println("ok");
	// Create new user's account
	//BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
	//String encodedPassword = encoder.encode(signUpRequest.getPassword());
	//String encodedPassword = signUpRequest.getPassword();
	//System.out.println(encodedPassword);
	Utilisateur user = new Utilisateur(signUpRequest.getUsername(), 
			signUpRequest.getEmail(),
			signUpRequest.getNom(),
			signUpRequest.getNumtel(),
			signUpRequest.getPrenom(),
			signUpRequest.getDate_creation_compte(),
			
						 encoder.encode(signUpRequest.getPassword()),
			//signUpRequest.getPassword(),
								 signUpRequest.getRole()		 );
	userRepository.save(user);

	return ResponseEntity.ok(new Response("User registered successfully!"));
}	




@RequestMapping(value="/authenticate", method=RequestMethod.POST)
public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest data) {
	System.out.println("aaaa");
	System.out.println(data.getPassword());
	System.out.println(data.getUsername());
	Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					data.getUsername(),
					data.getPassword())
			
			
			);
	
	  System.out.println("bbbbb");
	SecurityContextHolder.getContext().setAuthentication(authentication);
	String jwt = jwtUtils.generateJwtToken(authentication);
	
	MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();		
	
System.out.println(jwt);
System.out.println(userDetails.getUsername());

System.out.println(userDetails.getRole());

	return ResponseEntity.ok(new JwtResponse(jwt, 
											 userDetails.getId(), 
											 userDetails.getUsername(), 
											 userDetails.getEmail(),
											 userDetails.getNom(),
											 userDetails.getNumtel(),
											 userDetails.getPrenom(),
											 //userDetails.getDate_creation(),
											 
											 userDetails.getRole()));
}
@GetMapping(value="/listusers")
public List<Utilisateur> listusers(){
	return userserv.listusers();
	
}
@PutMapping("/update/{id}")
public Utilisateur update(@PathVariable(value="id") Long id, @Validated @RequestBody Utilisateur user) {
	return userserv.updateuser(id, user);
	

}
@PutMapping("/updatepass/{id}")
public Utilisateur updatepass(@PathVariable(value="id") Long id, @Validated @RequestBody Utilisateur user) {
	return userserv.updatepass(id, user);
	

}
@DeleteMapping(value="/listusers/{id}")
public void delete(@PathVariable(name="id") Long id ){
	
    userserv.remove(id);
}
}
