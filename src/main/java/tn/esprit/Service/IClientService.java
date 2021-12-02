package tn.esprit.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.Client;


public interface IClientService {
	
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
}
