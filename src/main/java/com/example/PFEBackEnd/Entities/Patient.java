package com.example.PFEBackEnd.Entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.OneToMany;

@Entity
@Table
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")

public class Patient implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long num_fiche;
	
	private String nom_patient;
	private String prenom_patient;
	private long num_tel1;
	private long num_tel2;
	private String adresse;
	private String email;
	private String sexe;
	private long cin;
	private long cnam;
	private String adre_par_qui;
	private String date_naissance;
	
	@OneToMany(mappedBy="patient" ,cascade = CascadeType.ALL)
     @JsonBackReference(value="patient-dossiers")
	private List<Dossier> dossiers;
	
	public List<Dossier> getDossiers() {
		return dossiers;
	}
	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
	
@OneToMany( mappedBy="patien",cascade = CascadeType.ALL)
@JsonBackReference(value="patient-document")
	private List<Document> documents;
	
	
	

	public List<Document> getDocuments() {
	return documents;
}
public void setDocuments(List<Document> documents) {
	this.documents = documents;
}
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Patient [num_fiche=" + num_fiche + ", nom_patient=" + nom_patient + ", prenom_patient=" + prenom_patient
				+ ", num_tel1=" + num_tel1 + ", num_tel2=" + num_tel2 + ", adresse=" + adresse + ", email=" + email
				+ ", sexe=" + sexe + ", cin=" + cin + ", cnam=" + cnam + ", adre_par_qui=" + adre_par_qui
				+ ", date_naissance=" + date_naissance + "]";
	}
	
	public long getNum_fiche() {
		return num_fiche;
	}
	public void setNum_fiche(long num_fiche) {
		this.num_fiche = num_fiche;
	}
	public String getNom_patient() {
		return nom_patient;
	}
	public void setNom_patient(String nom_patient) {
		this.nom_patient = nom_patient;
	}
	public String getPrenom_patient() {
		return prenom_patient;
	}
	public void setPrenom_patient(String prenom_patient) {
		this.prenom_patient = prenom_patient;
	}
	public long getNum_tel1() {
		return num_tel1;
	}
	public void setNum_tel1(long num_tel1) {
		this.num_tel1 = num_tel1;
	}
	public long getNum_tel2() {
		return num_tel2;
	}
	public void setNum_tel2(long num_tel2) {
		this.num_tel2 = num_tel2;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public long getCin() {
		return cin;
	}
	public void setCin(long cin) {
		this.cin = cin;
	}
	public long getCnam() {
		return cnam;
	}
	public void setCnam(long cnam) {
		this.cnam = cnam;
	}
	public String getAdre_par_qui() {
		return adre_par_qui;
	}
	public void setAdre_par_qui(String adre_par_qui) {
		this.adre_par_qui = adre_par_qui;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	
	
	

	
	
}
