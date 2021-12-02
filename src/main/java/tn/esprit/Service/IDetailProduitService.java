package tn.esprit.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.DetailProduit;



public interface IDetailProduitService {

	List<DetailProduit> retrieveAllDetails();
	
	DetailProduit addDetailProduit(DetailProduit df);
	
	void deleteDetailProduit(Long id);
	
	DetailProduit updateDetailProduit(DetailProduit df);
	
	DetailProduit retrieveDetailProduit(Long id);
}
