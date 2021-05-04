package com.example.PFEBackEnd.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Patient;


@Repository

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
