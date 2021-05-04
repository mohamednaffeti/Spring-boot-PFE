package com.example.PFEBackEnd.Entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Dossier implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_dossier;
	private String nom_dossier;
	private String date_creation_dossier;
	private String etat_paiement;
	private Long tarification;
	public Long getTarification() {
		return tarification;
	}
	public void setTarification(Long tarification) {
		this.tarification = tarification;
	}

	private String etat_dossier;


public String getEtat_dossier() {
		return etat_dossier;
	}
	public void setEtat_dossier(String etat_dossier) {
		this.etat_dossier = etat_dossier;
	}
	@OneToMany(mappedBy="dossier",cascade = CascadeType.ALL)
    @JsonBackReference(value="dossier-paiement")
	private List<Paiement> paiement;
	
	public List<Paiement> getPaiement() {
		return paiement;
	}
	public void setPaiement(List<Paiement> paiement) {
		this.paiement = paiement;
	}
	
	@OneToMany(mappedBy="dossier",cascade = CascadeType.ALL)
	@JsonBackReference(value="dossier-rdv")
	private List<Rendez_vous>rdvs;
	

	public List<Rendez_vous> getRdvs() {
		return rdvs;
	}
	public void setRdvs(List<Rendez_vous> rdvs) {
		this.rdvs = rdvs;
	}

	@ManyToOne
	@JoinColumn(name="num_fiche")
	//@JsonManagedReference
	private Patient patient;
	
public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
@ManyToOne
@JoinColumn(name="soin")

//@JsonManagedReference
private Soins soin;

    
	public Soins getSoin() {
	return soin;
}
public void setSoin(Soins soin) {
	this.soin = soin;
}
@ManyToOne
@JoinColumn(name="dent")

//@JsonManagedReference
private Dents dent;

public Dents getDent() {
return dent;
}
public void setDent(Dents dent) {
this.dent = dent;
}
   

/*@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="dossier")

private List<Rendez_vous> rendez_vous;

	public List<Rendez_vous> getRendez_vous() {
	return rendez_vous;
}
public void setRendez_vous(List<Rendez_vous> rendez_vous) {
	this.rendez_vous = rendez_vous;
}*/


	public Long getId_dossier() {
		return id_dossier;
	}
	public void setId_dossier(Long id_dossier) {
		this.id_dossier = id_dossier;
	}
	public String getNom_dossier() {
		return nom_dossier;
	}
	public void setNom_dossier(String nom_dossier) {
		this.nom_dossier = nom_dossier;
	}
	public String getDate_creation_dossier() {
		return date_creation_dossier;
	}
	public void setDate_creation_dossier(String date_creation_dossier) {
		this.date_creation_dossier = date_creation_dossier;
	}
	public String getEtat_paiement() {
		return etat_paiement;
	}
	public void setEtat_paiement(String etat_paiement) {
		this.etat_paiement = etat_paiement;
	}
	
}
