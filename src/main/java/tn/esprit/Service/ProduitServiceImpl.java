package tn.esprit.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.DetailProduit;
import tn.esprit.Entity.Produit;
import tn.esprit.Entity.Rayon;
import tn.esprit.Entity.Stock;
import tn.esprit.Repository.DetailProduitRepository;
import tn.esprit.Repository.ProduitRepository;
import tn.esprit.Repository.RayonRepository;
import tn.esprit.Repository.StockRepository;

@Slf4j
@Service
public class ProduitServiceImpl implements IProduitService{
	
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	DetailProduitRepository detailProduitRepository;

	@Override
	public Produit retrieveProduitById(long id) {
		return produitRepository.findById(id).orElse(null);
	}

	@Override
	public List<Produit> retrieveAllProduct() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for(Produit p : produits)
			log.info("Produit : " + p);
		return produits;
	}

	@Override
	@Transactional
	public Produit addProduit(Produit p,Long idRayon, Long idStock) {
		Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		p.setRayon(rayon);
		p.setStock(stock);
		log.info("Appel à la méthode save Detail Produit : " +p);
		DetailProduit dp = saveDetailProduit(p);
		p.setDetailProduit(dp);
		return produitRepository.save(p);
	}
	
	
	private DetailProduit saveDetailProduit(Produit p){
		if(p.getDetailProduit().getDateCreation() == null){
			p.getDetailProduit().setDateCreation(new Date());
			p.getDetailProduit().setDateDerniereModification(new Date());
		} else {
			p.getDetailProduit().setDateDerniereModification(new Date());
		}
		DetailProduit dp = detailProduitRepository.save(p.getDetailProduit());
		return dp;
	}

}
