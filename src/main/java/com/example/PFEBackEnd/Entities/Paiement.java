package com.example.PFEBackEnd.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Paiement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_paiement;
	private String date_paiement;
	private String mode_paiement;
	private Long montant;
	private String tache;
	
	
public String getTache() {
		return tache;
	}
	public void setTache(String tache) {
		this.tache = tache;
	}
@ManyToOne
	
	@JoinColumn(name="dossier")
	//@JsonManagedReference
	private Dossier dossier;


	public Dossier getDossier() {
	return dossier;
}
public void setDossier(Dossier dossier) {
	this.dossier = dossier;
}
	public Long getId_paiement() {
		return id_paiement;
	}
	public void setId_paiement(Long id_paiement) {
		this.id_paiement = id_paiement;
	}
	public String getDate_paiement() {
		return date_paiement;
	}
	public void setDate_paiement(String date_paiement) {
		this.date_paiement = date_paiement;
	}
	public String getMode_paiement() {
		return mode_paiement;
	}
	public void setMode_paiement(String mode_paiement) {
		this.mode_paiement = mode_paiement;
	}
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	
}
