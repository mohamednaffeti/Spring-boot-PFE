package com.example.PFEBackEnd.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Rendez_vous implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_rdv;
	private String date_rdv;
	
	private String date_debut;
	private String date_fin;
	private String tache;
	private String compte_rendu;
	private String etat;
	 
	@OneToMany(mappedBy="rendezvous" ,cascade = CascadeType.ALL)
    @JsonBackReference(value="rdv-ordonnance")
	private List<Ordonnance> ordonnance;
	
	
	
	
	public List<Ordonnance> getOrdonnances() {
		return ordonnance;
	}
	public void setOrdonnances(List<Ordonnance> ordonnance) {
		this.ordonnance = ordonnance;
	}
	@ManyToOne
	@JoinColumn(name="dossier")
	private Dossier dossier;
	
	
	
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	public long getId_rdv() {
		return id_rdv;
	}
	public void setId_rdv(long id_rdv) {
		this.id_rdv = id_rdv;
	}

	public String getTache() {
		return tache;
	}
	public void setTache(String tache) {
		this.tache = tache;
	}
	public String getCompte_rendu() {
		return compte_rendu;
	}
	public void setCompte_rendu(String compte_rendu) {
		this.compte_rendu = compte_rendu;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getDate_rdv() {
		return date_rdv;
	}
	public void setDate_rdv(String date_rdv) {
		this.date_rdv = date_rdv;
	}
	
}
