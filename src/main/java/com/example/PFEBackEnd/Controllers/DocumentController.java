package com.example.PFEBackEnd.Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.PFEBackEnd.Entities.Document;
import com.example.PFEBackEnd.Entities.Dossier;
import com.example.PFEBackEnd.domain.Response;
import com.example.PFEBackEnd.services.DocumentService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	DocumentService docserv;
	
	@Autowired  ServletContext context;
	@PostMapping(value="/add-document")
	public ResponseEntity<Response> createDocument (@RequestParam("file") MultipartFile file,
			 @RequestParam("document") String document) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
      Document doc = new ObjectMapper().readValue(document, Document.class);
      boolean isExit = new File(context.getRealPath("/Images/")).exists();
      if (!isExit)
      {
      	new File (context.getRealPath("webapp/Images/")).mkdir();
      	System.out.println("mk dir.............");
      }
      String filename = file.getOriginalFilename();
      String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
      File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
      try
      {
      	System.out.println("Image");
      	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
      	 
      }catch(Exception e) {
      	e.printStackTrace();
      }

     
      doc.setFileName(newFileName);
      Document doc1 = docserv.savedocument(doc);
      if (doc1!= null)
      {
      	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
      }
      else
      {
      	return new ResponseEntity<Response>(new Response ("image not saved"),HttpStatus.BAD_REQUEST);	
      }
	 }

	@GetMapping(value="/listdocuments")
	public List<Document> listdocuments(){ 
		return docserv.getDocumentt();
	}
	
	@GetMapping(path="/document/{id}")
	 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
		 Document document   = docserv.findById(id);
		 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+document.getFileName()));
	 }
	@DeleteMapping(value="/listdocuments/{id}")
	public void delete(@PathVariable(name="id") Long id ){
		
	    docserv.remove(id);
	}
}
