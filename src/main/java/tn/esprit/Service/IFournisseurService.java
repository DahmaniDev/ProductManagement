package tn.esprit.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.Fournisseur;


@Service
public interface IFournisseurService {

	List<Fournisseur> retrieveAllFournisseurs();
	
	Fournisseur addFournisseur(Fournisseur df);
	
	void deleteFournisseur(Long id);
	
	Fournisseur updateFournisseur(Fournisseur df);
	
	Fournisseur retrieveFournisseur(Long id);
}
