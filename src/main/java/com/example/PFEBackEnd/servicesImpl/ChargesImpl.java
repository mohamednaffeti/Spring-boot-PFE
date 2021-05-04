package com.example.PFEBackEnd.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Charges;

import com.example.PFEBackEnd.Repositories.ChargeRepository;
import com.example.PFEBackEnd.services.ChargeService;
@Service
public class ChargesImpl implements ChargeService{
@Autowired
ChargeRepository chargeRepo;
	@Override
	public void saveCharge(Charges charge) {
		chargeRepo.save(charge);
		
	}

	@Override
	public List<Charges> listcharges() {
		return chargeRepo.findAll();
	}

	@Override
	public void removeCharge(Long id) {
		chargeRepo.deleteById(id);
		
	}

	@Override
	public Charges findById(Long id) {
		Optional<Charges> charge = chargeRepo.findById(id);
		return charge.isPresent() ? charge.get() : null;
	}

	@Override
	public Charges updatecharge(Long id, Charges newcharge) {
		Optional<Charges>charge=chargeRepo.findById(id);
		if(charge.isPresent()) {
			Charges charge1=charge.get();
			charge1.setDate_paiement(newcharge.getDate_paiement());
			charge1.setMode_paiement(newcharge.getMode_paiement());
			charge1.setType_charge(newcharge.getType_charge());
			charge1.setMontant(newcharge.getMontant());
			Charges c1=chargeRepo.save(charge1);
			return c1;
		}
		return null;
	}

}
