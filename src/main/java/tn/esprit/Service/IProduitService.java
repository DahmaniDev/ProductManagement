package tn.esprit.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.Produit;


@Service
public interface IProduitService {
	
	Produit retrieveProduitById(long id);
	List<Produit> retrieveAllProduct();
	Produit addProduit(Produit p,Long idRayon, Long idStock);
}
