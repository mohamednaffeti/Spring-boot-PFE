package com.example.PFEBackEnd.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Selectable;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table
public class Dents implements Serializable{
	@Id
	
private long id_dent;
private String libelle_dent;
public long getId_dent() {
	return id_dent;
}
public void setId_dent(long id_dent) {
	this.id_dent = id_dent;
}
public String getLibelle_dent() {
	return libelle_dent;
}
public void setLibelle_dent(String libelle_dent) {
	this.libelle_dent = libelle_dent;
}
@OneToMany(mappedBy="dent",cascade = CascadeType.ALL)
@JsonBackReference(value="dents-dossiers")
private List<Dossier> dossiers;
public List<Dossier> getDossiers() {
	return dossiers;
}
public void setDossiers(List<Dossier> dossiers) {
	this.dossiers = dossiers;
}

}
