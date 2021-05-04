package com.example.PFEBackEnd.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Document;
import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.Repositories.DocumentRepository;
import com.example.PFEBackEnd.services.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{
@Autowired
DocumentRepository documentRepo;
	@Override
	public Document savedocument(Document document) {
		
		return documentRepo.save(document);
	}
	@Override
	public List<Document> getDocumentt() {
				return documentRepo.findAll();
	}
	@Override
	public Document findById(Long id) {
		Optional<Document>document=documentRepo.findById(id);
		return document.isPresent() ? document.get() : null;
	}
	@Override
	public void remove(Long id) {
		documentRepo.deleteById(id);
		
	}

}
