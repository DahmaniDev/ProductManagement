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

import tn.esprit.Entity.Facture;
import tn.esprit.Service.IFactureService;

@RestController
@RequestMapping("/Facture")
public class FactureController {

	@Autowired
	IFactureService factureService;
	//Working
	@PostMapping("/add")
	@ResponseBody
	Facture addFacture(@RequestBody Facture f){
		return factureService.addFacture(f);
	}
	//Working
	@GetMapping("/get-all")
	@ResponseBody
	List<Facture> getAllFactures(){
		return factureService.retrieveAllFactures();
	}
	//Working
	@GetMapping("/get/{idFacture}")
	@ResponseBody
	Facture getFacture(@PathVariable("idFacture")  Long id){
		return factureService.retrieveFacture(id);
	}
	//Working
	@PutMapping("/cancel/{idFacture}")
	@ResponseBody
	void cancelFacture(@PathVariable("idFacture")  Long id){
		factureService.cancelFacture(id);
	}
}
