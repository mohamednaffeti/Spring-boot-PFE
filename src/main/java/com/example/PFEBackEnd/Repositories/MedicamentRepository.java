package com.example.PFEBackEnd.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Medicament;
@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long>{
	Optional<Medicament> findById(Long id);

}
