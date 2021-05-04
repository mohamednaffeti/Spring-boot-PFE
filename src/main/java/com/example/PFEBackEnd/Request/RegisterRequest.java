package com.example.PFEBackEnd.Request;
import javax.validation.constraints.*;
public class RegisterRequest {
	@NotBlank
   
    private String username;
    @NotBlank
   
    @NotBlank
    private String role;
    @NotBlank
   
    private String password;
    @NotBlank
    
    private String email;
    @NotBlank
    
    private String nom;
    @NotBlank
    
    private String prenom;
    @NotBlank
    
    private String numtel;
    @NotBlank
    
    private String date_creation_compte;
	public String getDate_creation_compte() {
		return date_creation_compte;
	}
	public void setDate_creation_compte(String date_creation_compte) {
		this.date_creation_compte = date_creation_compte;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
