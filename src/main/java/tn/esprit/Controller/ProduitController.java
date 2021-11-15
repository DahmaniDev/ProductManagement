package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	Produit addProduit(@RequestBody Produit p, @PathVariable("idRayon") Long idRayon, @PathVariable("idStock") Long idStock){
		return produitService.addProduit(p, idRayon, idStock);
	}
	
	@GetMapping("/get-all")
	@ResponseBody
	List<Produit> getAllProduits(){
		return produitService.retrieveAllProduct();
	}
	
	
}
