package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Soins;

@Service
public interface SoinsService {
	 void savesoins(Soins soins);
     List<Soins> listsoins();
     void remove(Long id);
     public Soins findById(Long id);
     Soins updatesoins(Long id,Soins soins);
}
