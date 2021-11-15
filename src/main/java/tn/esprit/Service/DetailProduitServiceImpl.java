package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.DetailProduit;
import tn.esprit.Repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl implements IDetailProduitService{

	@Autowired
	DetailProduitRepository detailProduitRepository;
	
	@Override
	public List<DetailProduit> retrieveAllDetails() {
		return (List<DetailProduit>) detailProduitRepository.findAll();
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit df) {
		return detailProduitRepository.save(df);
	}

	@Override
	public void deleteDetailProduit(Long id) {
		detailProduitRepository.deleteById(id);
		
	}

	@Override
	public DetailProduit updateDetailProduit(DetailProduit df) {
		return detailProduitRepository.save(df);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		return detailProduitRepository.findById(id).orElse(null);
	}

}
