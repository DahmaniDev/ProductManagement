package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.RayonRepository;
import tn.esprit.entity.Rayon;

@Service
public class RayonServiceImpl implements IRayonService{
	
	@Autowired
	RayonRepository rayonRepository;

	@Override
	public List<Rayon> retrieveAllRayons() {
		return (List<Rayon>) rayonRepository.findAll();
	}

	@Override
	public Rayon addRayon(Rayon df) {
		return rayonRepository.save(df);
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepository.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon df) {
		return rayonRepository.save(df);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		return rayonRepository.findById(id).orElse(null);
	}

}
