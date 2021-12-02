package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Produit;
import tn.esprit.Service.IProduitService;

@RestController
@RequestMapping("/Produit")
public class ProduitController {

	@Autowired
	IProduitService produitService;
	
	@GetMapping("/get/{idProduit}")
	@ResponseBody
	Produit getProduit(@PathVariable("idProduit") Long id){
		return produitService.retrieveProduitById(id);
	}
	
	@PostMapping("/add/{idRayon}/{idStock}")
	@ResponseBody
	Produit addProduit(@RequestBody Produit p,@PathVariable("idRayon") Long idR, @PathVariable("idStock") Long idS){
		return produitService.addProduit(p, idR, idS);
	}
	
	@GetMapping("/get-all")
	@ResponseBody
	List<Produit> getAllProduits(){
		return produitService.retrieveAllProduct();
	}
	
	@PutMapping("/assign-stock/{idProduit}/{idStock}")
	@ResponseBody
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit,@PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}
	
	@PutMapping("/assign-forunisseur/{idProduit}/{idFournisseur}")
	@ResponseBody
	public void assignFournisseurToProduit(@PathVariable("idFournisseur") Long fournisseurId,@PathVariable("idProduit") Long produitId) {
		produitService.assignFournisseurToProduit(fournisseurId, produitId);
	}
	
}
