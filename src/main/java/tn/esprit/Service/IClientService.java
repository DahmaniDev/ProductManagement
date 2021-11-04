package tn.esprit.Service;

import java.util.List;
import tn.esprit.entity.Client;
import org.springframework.stereotype.Service;


@Service
public interface IClientService {
	
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
}
