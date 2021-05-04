package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Charges;


@Service
public interface ChargeService {
void saveCharge(Charges charge);
	
	
	List<Charges> listcharges();
	void removeCharge (Long id);
	public Charges findById(Long id);
	Charges updatecharge(Long id, Charges newcharge);
}
