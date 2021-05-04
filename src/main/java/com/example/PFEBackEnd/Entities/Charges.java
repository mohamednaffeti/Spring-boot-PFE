package com.example.PFEBackEnd.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Charges implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_charge;
	private String type_charge;
	private String date_paiement;
	private String mode_paiement;
	private int montant;
	public long getId_charge() {
		return id_charge;
	}
	public void setId_charge(long id_charge) {
		this.id_charge = id_charge;
	}
	public String getType_charge() {
		return type_charge;
	}
	public void setType_charge(String type_charge) {
		this.type_charge = type_charge;
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
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
}
