package com.example.PFEBackEnd.domain;

public class JwtResponse {
	private String jwt;
	private Long id;
	private String username;
	private String email;
	private String nom;
	private String prenom;
	private String numtel;
	private String Date_creation_compte;
	
	public String getDate_creation_compte() {
		return Date_creation_compte;
	}

	public void setDate_creation_compte(String date_creation_compte) {
		Date_creation_compte = date_creation_compte;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}

	private String role;

	/*public JwtResponse(String accessToken, Long id, String username, String role) {
		this.jwt = accessToken;
		this.id = id;
		this.username = username;
	
		this.role = role;
	}*/

	public String getAccessToken() {
		return jwt;
	}

	public JwtResponse(String jwt, Long id, String username, String email, String nom, String prenom, String numtel,
			String role) {
		super();
		this.jwt = jwt;
		this.id = id;
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.numtel = numtel;
		this.role = role;
		//this.Date_creation_compte=date_creation_compte;
	}

	public void setAccessToken(String accessToken) {
		this.jwt = accessToken;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
