package com.example.PFEBackEnd.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table
public class Medicament implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_medicament;
	private String code;
	private String libelle;
	private String nbr_fois;
	
	
	
	@OneToMany(mappedBy="medicament" ,cascade = CascadeType.ALL)
    @JsonBackReference(value="medicament-ordonnance")
	private List<Ordonnance> ordonnance;
	
	public List<Ordonnance> getOrdonnance() {
		return ordonnance;
	}
	public void setOrdonnance(List<Ordonnance> ordonnance) {
		this.ordonnance = ordonnance;
	}
	
	
	
	
	public Long getId_medicament() {
		return id_medicament;
	}
	public void setId_medicament(Long id_medicament) {
		this.id_medicament = id_medicament;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getNbr_fois() {
		return nbr_fois;
	}
	public void setNbr_fois(String nbr_fois) {
		this.nbr_fois = nbr_fois;
	}
}
