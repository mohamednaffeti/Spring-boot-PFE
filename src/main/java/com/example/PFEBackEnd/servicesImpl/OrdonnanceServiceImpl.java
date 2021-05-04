package com.example.PFEBackEnd.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Ordonnance;
import com.example.PFEBackEnd.Repositories.OrdonnanceRepository;
import com.example.PFEBackEnd.services.OrdonnanceService;

@Service
public class OrdonnanceServiceImpl implements OrdonnanceService {
@Autowired
OrdonnanceRepository ordorepo;
	@Override
	public void saveordonnace(Ordonnance ordonnance) {
		ordorepo.save(ordonnance);
		
	}

	@Override
	public List<Ordonnance> getordonnances() {
		return ordorepo.findAll();
	}

	@Override
	public void remove(Long id) {
		ordorepo.deleteById(id);
		
	}

}
