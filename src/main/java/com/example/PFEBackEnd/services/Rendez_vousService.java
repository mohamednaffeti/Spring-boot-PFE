package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.PFEBackEnd.Entities.Rendez_vous;

@Service
public interface Rendez_vousService {
void saverdv(Rendez_vous rendez_vous);
	
	
	List<Rendez_vous> listrdv();
	void removeRendez_vous (Long id);
	public Rendez_vous findById(Long id);
	Rendez_vous updaterdv(Long id, Rendez_vous rendez_vous);
}
