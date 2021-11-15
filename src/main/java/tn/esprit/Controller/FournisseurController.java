package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Fournisseur;
import tn.esprit.Service.IFournisseurService;

@RestController
@RequestMapping("/Fournisseur")
public class FournisseurController {

	@Autowired
	IFournisseurService fournisseurService;
	
	//Working
	@PostMapping("/add")
	@ResponseBody
	Fournisseur addFournisseur(@RequestBody Fournisseur f){
		return fournisseurService.addFournisseur(f);
	}
	//Working
	@GetMapping("/get-all")
	@ResponseBody
	List<Fournisseur> getAllForunisseurs(){
		return fournisseurService.retrieveAllFournisseurs();
	}
	//Working
	@GetMapping("/get/{idFournisseur}")
	@ResponseBody
	Fournisseur getFournisseur(@PathVariable("idFournisseur") Long id){
		return fournisseurService.retrieveFournisseur(id);
	}
	//Working
	@DeleteMapping("/delete/{idFournisseur}")
	@ResponseBody
	void deleteFournisseur(@PathVariable("idFournisseur") Long id){
		fournisseurService.deleteFournisseur(id);
	}
	//Working
	@PutMapping("/update")
	@ResponseBody
	Fournisseur updateFournisseur(@RequestBody Fournisseur f){
		return fournisseurService.updateFournisseur(f);
	}
}
