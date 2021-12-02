package tn.esprit.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.DetailProduit;
import tn.esprit.Entity.Fournisseur;
import tn.esprit.Entity.Produit;
import tn.esprit.Entity.Rayon;
import tn.esprit.Entity.Stock;
import tn.esprit.Repository.DetailProduitRepository;
import tn.esprit.Repository.FournisseurRepository;
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
	@Autowired
	FournisseurRepository fournisseurRepository;

	@Override
	public Produit retrieveProduitById(long id) {
		return produitRepository.findById(id).orElse(null);
	}

	@Override
	public List<Produit> retrieveAllProduct() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		return produits;
	}

	@Override
	@Transactional
	public Produit addProduit(Produit p,Long idRayon, Long idStock) {
		Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		p.setRayon(rayon);
		p.setStock(stock);
		DetailProduit dp = saveDetailProduit(p);
		p.setDetailProduit(dp);
		stock.setQteStock(stock.getQteStock()+1);
		stockRepository.save(stock);
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

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = produitRepository.findById(idProduit).orElse(null);
		if(p!=null){
			p.setStock(stockRepository.findById(idStock).orElse(null));
			produitRepository.save(p);
		} else {
			log.info("Update of a product that doesn't exist");
		}
		
	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Produit p = produitRepository.findById(produitId).orElse(null);
		Set<Fournisseur> fournisseurs = p.getFournisseurs();
		Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
		if(p!=null && f!=null){
			fournisseurs.add(f);
			p.setFournisseurs(fournisseurs);
			produitRepository.save(p);
		}else{
			log.error("Update of product ERROR : Either product or provider are nullable ");
		}
		
	}

}
