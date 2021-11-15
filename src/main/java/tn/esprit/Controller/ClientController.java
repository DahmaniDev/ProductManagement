package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.Entity.Client;
import tn.esprit.Service.IClientService;

@RestController
@RequestMapping("/Client")
public class ClientController {

	@Autowired
	IClientService clientService;
	
	//Working
	@PostMapping("/add")
	@ResponseBody		//Pour parcourir l'objet retourné dans le front-end
	Client addClient(@RequestBody Client c) {
		return clientService.addClient(c);
	}
	//Working
	@GetMapping("/get/{idClient}")
	@ResponseBody
	Client getClient(@PathVariable("idClient") Long id) {
		return clientService.retrieveClient(id);
	}
	//Working
	@GetMapping("/get-all")
	@ResponseBody
	List<Client> getAllClients(){
		return clientService.retrieveAllClients();
	}
	//Working
	@DeleteMapping("/delete/{idClient}")
	@ResponseBody
	void deleteClient(@PathVariable("idClient") Long idClient){
		clientService.deleteClient(idClient);
	}
	//Working
	@PutMapping("/update")
	@ResponseBody		
	Client updateClient(@RequestBody Client c) {
		return clientService.updateClient(c);
	}
	
}
