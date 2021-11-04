package tn.esprit.Service;

import java.util.List;

import tn.esprit.entity.Produit;
import org.springframework.stereotype.Service;


@Service
public interface IProduitService {
	
	Produit retrieveProduitById(long id);
	List<Produit> retrieveAllProduct();
	Produit addProduit(Produit p,Long idRayon, Long idStock);
}
