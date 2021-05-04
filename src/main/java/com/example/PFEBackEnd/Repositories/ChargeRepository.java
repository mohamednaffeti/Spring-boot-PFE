package com.example.PFEBackEnd.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Charges;

@Repository
public interface ChargeRepository extends JpaRepository<Charges,Long>{

}
