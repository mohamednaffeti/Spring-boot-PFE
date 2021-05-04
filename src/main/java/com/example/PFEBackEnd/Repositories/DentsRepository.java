package com.example.PFEBackEnd.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PFEBackEnd.Entities.Dents;
@Repository
public interface DentsRepository extends JpaRepository<Dents,Long>{

}
