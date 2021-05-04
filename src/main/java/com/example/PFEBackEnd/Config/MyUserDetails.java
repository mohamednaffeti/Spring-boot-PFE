package com.example.PFEBackEnd.Config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.PFEBackEnd.Entities.Utilisateur;

public class MyUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String password;
	private boolean isActive;
	private String Role;
	private String nom;
	private String prenom;
	private String email;
	private String numtel;
	private String date_creation;
	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails(Utilisateur user) {
		this.userName=user.getUsername();
		this.password=user.getPassword();
		//this.isActive=user.isActive();
		this.isActive=true;
		this.id=user.getId();
		this.Role=user.getRole();
		this.email=user.getEmail();
		this.nom=user.getNom();
		this.prenom=user.getPrenom();
		this.numtel=user.getNumtel();
		this.date_creation=user.getDate_creation_compte();
		this.authorities=Arrays.stream(user.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		System.out.println("ok");
		System.out.println(user);
	}
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MyUserDetails() {
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isActive;
	}
	
	
}
