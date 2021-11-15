package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.Facture;
import tn.esprit.Repository.FactureRepository;

@Slf4j
@Service
public class FactureServiceImpl implements IFactureService{
	
	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f = factureRepository.findById(id).orElse(null);
		f.setActive(false);
		log.info("Facture Canceled : " +f);
		factureRepository.save(f);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return factureRepository.findById(id).orElse(null);
	}

	@Override
	public Facture addFacture(Facture f) {
		return factureRepository.save(f);
	}

}
