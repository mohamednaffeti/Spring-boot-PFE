package com.example.PFEBackEnd.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table
public class Utilisateur implements Serializable{
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public Utilisateur( @NotBlank String username, String password, String role
			) {
		super();
	    
		this.username = username;
		this.password = password;
		this.role = role;
		
	}*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
	

	/*public Utilisateur(@NotBlank String username, String nom, String prenom, String email, Long numtel, String password,
			String role) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numtel = numtel;
		this.password = password;
		this.role = role;
	}*/
	/*public Utilisateur(String username2, String email2, String nom2, String numtel2, String prenom2, String encode,
			String role2,String date) {
		this.username = username2;
		this.email = email2;
		this.nom = nom2;
		this.numtel = numtel2;
		this.prenom = prenom2;
		this.password=encode;
		this.role=role2;
		this.date_creation_compte=date;
	}*/
	public Utilisateur(String username2, String email2, String nom2, String numtel2, String prenom2,
			String date_creation_compte2, String encode, String role2) {
		this.username = username2;
		this.email = email2;
		this.nom = nom2;
		this.numtel = numtel2;
		this.prenom = prenom2;
		this.password=encode;
		this.role=role2;
		this.date_creation_compte=date_creation_compte2;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDate_creation_compte() {
		return date_creation_compte;
	}
	public void setDate_creation_compte(String date_creation_compte) {
		this.date_creation_compte = date_creation_compte;
	}
	@NotBlank
	private String username;
	private String nom;
	private String prenom;
	private String email;
	private String numtel;
	
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

	private String password;
	  private String role;
	  private String date_creation_compte;
	  private boolean isActive;
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", date_creation_compte=" + date_creation_compte + ", isActive=" + isActive + "]";
	}
	
}
