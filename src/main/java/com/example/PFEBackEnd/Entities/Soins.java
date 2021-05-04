package com.example.PFEBackEnd.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Soins implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_soin;
	private String libelle_soin;
	private int nombre_seance;
	private int tarification;
    public int getTarification() {
		return tarification;
	}
	public void setTarification(int tarification) {
		this.tarification = tarification;
	}
	@OneToMany( cascade=CascadeType.ALL,mappedBy="soin")
	@JsonBackReference(value="soin-dossiers")
	private List<Dossier> dossiers;

	public List<Dossier> getDossiers() {
	return dossiers;
    }
     public void setDossiers(List<Dossier> dossiers) {
	this.dossiers = dossiers;
     }
     
     
	
	public Long getId_soin() {
		return id_soin;
	}
	public void setId_soin(Long id_soin) {
		this.id_soin = id_soin;
	}
	public String getLibelle_soin() {
		return libelle_soin;
	}
	public void setLibelle_soin(String libelle_soin) {
		this.libelle_soin = libelle_soin;
	}
	public int getNombre_seance() {
		return nombre_seance;
	}
	public void setNombre_seance(int nombre_seance) {
		this.nombre_seance = nombre_seance;
	}
	
}
