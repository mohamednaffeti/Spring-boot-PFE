package com.example.PFEBackEnd.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
public class Document implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id_document;
private String nom_document;
private String date_creation_document;
private String categorie_document;
//private long fiche;

private String fileName;
@ManyToOne
@JoinColumn(name="num_fiche")
//@JsonManagedReference
private Patient patien;


public Patient getPatien() {
	return patien;
}
public void setPatien(Patient patien) {
	this.patien = patien;
}
public long getId_document() {
	return id_document;
}
public void setId_document(long id_document) {
	this.id_document = id_document;
}
public String getNom_document() {
	return nom_document;
}
public void setNom_document(String nom_document) {
	this.nom_document = nom_document;
}
public String getDate_creation_document() {
	return date_creation_document;
}
public void setDate_creation_document(String date_creation_document) {
	this.date_creation_document = date_creation_document;
}
public String getCategorie_document() {
	return categorie_document;
}
public void setCategorie_document(String categorie_document) {
	this.categorie_document = categorie_document;
}


public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}

}
