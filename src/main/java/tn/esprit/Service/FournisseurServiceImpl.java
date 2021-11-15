package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Fournisseur;
import tn.esprit.Repository.FournisseurRepository;

@Service
public class FournisseurServiceImpl implements IFournisseurService{
	
	@Autowired
	FournisseurRepository fournisseurRepository;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		return (List<Fournisseur>) fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur df) {
		return fournisseurRepository.save(df);
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur df) {
		return fournisseurRepository.save(df);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		return fournisseurRepository.findById(id).orElse(null);
	}

}
