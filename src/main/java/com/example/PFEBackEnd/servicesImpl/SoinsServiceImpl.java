package com.example.PFEBackEnd.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PFEBackEnd.Entities.Soins;
import com.example.PFEBackEnd.Repositories.SoinsRepository;
import com.example.PFEBackEnd.services.SoinsService;
@Service
public class SoinsServiceImpl implements SoinsService{
	@Autowired
	SoinsRepository soinsrepository;
		@Override
		public void savesoins(Soins soins) {
			soinsrepository.save(soins);
			
		}

		@Override
		public List<Soins> listsoins() {
			
			return soinsrepository.findAll();
		}

		@Override
		public void remove(Long id) {
			soinsrepository.deleteById(id);
			
		}

		@Override
		public Soins findById(Long id) {
			Optional<Soins>soins=soinsrepository.findById(id);
			return soins.isPresent() ? soins.get() : null;
		}

		@Override
		public Soins updatesoins(Long id, Soins soins) {
			Optional<Soins>soin=soinsrepository.findById(id);
			if(soin.isPresent()) {
				Soins soin1=soin.get();
				soin1.setLibelle_soin(soins.getLibelle_soin());
				soin1.setTarification(soins.getTarification());
				soin1.setNombre_seance(soins.getNombre_seance());
				Soins soin2=soinsrepository.save(soin1);
				return soin2;
				
			}
			return null;
		}
}
