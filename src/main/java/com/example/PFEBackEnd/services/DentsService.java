package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Dents;


@Service
public interface DentsService {
	List<Dents> getDents();
}
