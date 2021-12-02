package tn.esprit.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.CategorieClient;
import tn.esprit.Entity.Facture;


public interface IFactureService {

	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	Facture addFacture(Facture f);
	List<Facture> getFacturesByClient(Long idClient);
	Facture addFacture(Facture f, Long idClient);
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date startDate, Date endDate);
}
