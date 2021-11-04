package tn.esprit.Service;

import java.util.List;

import tn.esprit.entity.DetailProduit;
import org.springframework.stereotype.Service;


@Service
public interface IDetailProduitService {

	List<DetailProduit> retrieveAllDetails();
	
	DetailProduit addDetailProduit(DetailProduit df);
	
	void deleteDetailProduit(Long id);
	
	DetailProduit updateDetailProduit(DetailProduit df);
	
	DetailProduit retrieveDetailProduit(Long id);
}
