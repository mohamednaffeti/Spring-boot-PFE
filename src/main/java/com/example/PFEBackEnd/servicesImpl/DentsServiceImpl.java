package com.example.PFEBackEnd.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Dents;
import com.example.PFEBackEnd.Repositories.DentsRepository;
import com.example.PFEBackEnd.services.DentsService;
@Service
public class DentsServiceImpl implements DentsService{
@Autowired
DentsRepository dentsrepo;
	@Override
	public List<Dents> getDents() {
		return dentsrepo.findAll();
	}

}
