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

import tn.esprit.Entity.Rayon;
import tn.esprit.Service.IRayonService;

@RestController
@RequestMapping("/Rayon")
public class RayonController {

	@Autowired
	IRayonService rayonService;
	
	@PostMapping("/add")
	@ResponseBody
	Rayon addRayon(@RequestBody Rayon r){
		return rayonService.addRayon(r);
	}
	
	@GetMapping("/get-all")
	@ResponseBody
	List<Rayon> getAllRayons(){
		return rayonService.retrieveAllRayons();
	}
	
	@GetMapping("/get/{idRayon}")
	@ResponseBody
	Rayon getRayon(@PathVariable("idRayon") Long id){
		return rayonService.retrieveRayon(id);
	}
	
	@DeleteMapping("/delete/{idRayon}")
	@ResponseBody
	void deleteRayon(@PathVariable("idRayon") Long id){
		rayonService.deleteRayon(id);
	}
	
	@PutMapping("/update")
	@ResponseBody
	Rayon updateRayon(@RequestBody Rayon r){
		return rayonService.updateRayon(r);
	}
}
