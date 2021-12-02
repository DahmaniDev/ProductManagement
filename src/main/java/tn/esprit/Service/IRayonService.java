package tn.esprit.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.Rayon;


public interface IRayonService {

	List<Rayon> retrieveAllRayons();
	
	Rayon addRayon(Rayon df);
	
	void deleteRayon(Long id);
	
	Rayon updateRayon(Rayon df);
	
	Rayon retrieveRayon(Long id);
}
