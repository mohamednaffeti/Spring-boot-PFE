package com.example.PFEBackEnd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PFEBackEnd.Entities.Dents;

import com.example.PFEBackEnd.services.DentsService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/dents")
public class DentsController {
@Autowired
DentsService dentserv;
@GetMapping(value="/listdents")
public List<Dents> listDents(){
	return dentserv.getDents();
}
}
