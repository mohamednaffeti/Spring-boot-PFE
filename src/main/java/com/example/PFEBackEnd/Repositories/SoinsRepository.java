package com.example.PFEBackEnd.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Soins;

@Repository
public interface SoinsRepository extends JpaRepository<Soins, Long> {

}
