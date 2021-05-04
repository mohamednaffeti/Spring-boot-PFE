package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Ordonnance;

@Service
public interface OrdonnanceService {
	void saveordonnace(Ordonnance ordonnance);
    List<Ordonnance> getordonnances();
    void remove(Long id);
}
