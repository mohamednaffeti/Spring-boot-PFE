package com.example.PFEBackEnd.Entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table

public class Ordonnance implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nbr_fois;
   private String libelle;
	
	


	public String getLibelle() {
	return libelle;
}


public void setLibelle(String libelle) {
	this.libelle = libelle;
}


	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="rendezvous")
	//@JsonManagedReference
	private Rendez_vous rendezvous;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="medicament")
	//@JsonManagedReference
	private Medicament medicament;
	
	public String getNbr_fois() {
		return nbr_fois;
	}


	public void setNbr_fois(String nbr_fois) {
		this.nbr_fois = nbr_fois;
	}

       @JsonProperty("medicament")
	public Long getMedicament() {
		return medicament.getId_medicament();
	}
   

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("rendezvous")
	public Long getRendezvous() {
		return rendezvous.getId_rdv();
	}


	public void setRendezvous(Rendez_vous rendezvous) {
		this.rendezvous = rendezvous;
	}
}
