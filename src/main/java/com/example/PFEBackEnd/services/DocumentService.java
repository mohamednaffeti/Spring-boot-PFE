package com.example.PFEBackEnd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Document;


@Service
public interface DocumentService {
	Document savedocument(Document document);
	List<Document> getDocumentt();
	public Document findById(Long id);
	void remove(Long id);
}
