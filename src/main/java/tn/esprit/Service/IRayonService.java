package tn.esprit.Service;

import java.util.List;

import tn.esprit.entity.Rayon;
import org.springframework.stereotype.Service;


@Service
public interface IRayonService {

	List<Rayon> retrieveAllRayons();
	
	Rayon addRayon(Rayon df);
	
	void deleteRayon(Long id);
	
	Rayon updateRayon(Rayon df);
	
	Rayon retrieveRayon(Long id);
}
